package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public class BirthdayServiceTest {
	private List<Employee> employees = new ArrayList<>();
	private FakeMessage message;
	private BirthdayService<FakeMessage> tested;
	private boolean hasBirthday;

	@Before
	public void setup() {
		tested = new BirthdayService<>(m -> message = m, () -> employees, FakeMessage::new, (b, d) -> hasBirthday);
	}

	@Test
	public void employeeHasNotBirthday() {
		addEmployee();
		hasBirthday = false;

		sendMessage();

		assertEquals(null, message);
	}

	@Test
	public void employeeHasBirthday() {
		Employee e = addEmployee();
		hasBirthday = true;

		sendMessage();

		assertEquals(e, message.employee);
	}

	private void sendMessage() {
		tested.sendGreetings(null);
	}

	private Employee addEmployee() {
		Employee e = new Employee("", "", null, "");
		employees.add(e);
		return e;
	}

	private class FakeMessage extends Message {
		public Employee employee;

		public FakeMessage(Employee employee) {
			this.employee = employee;
		}
	}
}
