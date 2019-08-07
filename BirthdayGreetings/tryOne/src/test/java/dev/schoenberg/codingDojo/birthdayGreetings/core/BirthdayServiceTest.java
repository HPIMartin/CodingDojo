package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BirthdayServiceTest {
	private FakeRepo repo;
	private FakeSender sender;
	private BirthdayService<FakeMessage> tested;

	@Before
	public void setup() {
		sender = new FakeSender();
		repo = new FakeRepo();
		tested = new BirthdayService<FakeMessage>(sender, repo, FakeMessage::new);
	}

	@Test
	public void employeeHasNotBirthday() {
		addEmployee("2000/01/01");

		sendMessage("2000/01/02");

		assertFalse(sender.hasMessage());
	}

	@Test
	public void employeeHasBirthday() {
		Employee e = addEmployee("2000/01/01");

		sendMessage("2020/01/01");

		assertTrue(sender.hasMessage());
		assertEquals(e, sender.message.employee);
	}

	private void sendMessage(String yyyyMMdd) {
		tested.sendGreetings(new XDate(yyyyMMdd));
	}

	private Employee addEmployee(String birthDate) {
		Employee e = new Employee("", "", birthDate, "");
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
