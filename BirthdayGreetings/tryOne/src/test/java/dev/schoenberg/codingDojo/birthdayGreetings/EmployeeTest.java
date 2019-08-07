package dev.schoenberg.codingDojo.birthdayGreetings;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void testBirthday() {
		Employee employee = new Employee("foo", "bar", "1990/01/31", "a@b.c");
		assertFalse(employee.isBirthday(new XDate("2008/01/30")));
		assertTrue(employee.isBirthday(new XDate("2008/01/31")));
	}
}
