package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Birthday;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public class BirthdayServiceTest {
	private FakeRepo repo;
	private FakeSender sender;
	private BirthdayService<FakeMessage> tested;
	private FakeChecker checker;

	@Before
	public void setup() {
		sender = new FakeSender();
		repo = new FakeRepo();
		checker = new FakeChecker();
		tested = new BirthdayService<FakeMessage>(sender, repo, FakeMessage::new, checker);
	}

	@Test
	public void employeeHasNotBirthday() {
		addEmployee();
		checker.hasBirthDay = false;

		sendMessage();

		assertFalse(sender.hasMessage());
	}

	@Test
	public void employeeHasBirthday() {
		Employee e = addEmployee();
		checker.hasBirthDay = true;

		sendMessage();

		assertTrue(sender.hasMessage());
		assertEquals(e, sender.message.employee);
	}

	private void sendMessage() {
		tested.sendGreetings(null);
	}

	private Employee addEmployee() {
		Employee e = new Employee("", "", null, "");
		repo.employees.add(e);
		return e;
	}

	private class FakeRepo implements EmployeeRepository {
		public final List<Employee> employees = new ArrayList<>();

		@Override
		public List<Employee> getEmployees() {
			return employees;
		}
	}

	private class FakeChecker extends BirthdayChecker {
		public boolean hasBirthDay = false;

		@Override
		public boolean isBirthday(Birthday birthday, LocalDate today) {
			return hasBirthDay;
		}
	}

	private class FakeMessage extends Message {
		public Employee employee;

		public FakeMessage(Employee employee) {
			this.employee = employee;
		}

	}

	private class FakeSender implements Sender<FakeMessage> {
		public FakeMessage message;

		@Override
		public void sendMessage(FakeMessage message) {
			this.message = message;
		}

		public boolean hasMessage() {
			return message != null;
		}
	}
}
