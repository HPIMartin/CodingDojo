package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void testBirthday() {
		Employee employee = new Employee("", "", "1990/01/31", "");
		assertFalse(employee.isBirthday(new XDate("2008/01/30")));
		assertTrue(employee.isBirthday(new XDate("2008/01/31")));
	}
}
