package dev.schoenberg.codingDojo.birthdayGreetings.email;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.core.Employee;

public class BirthdayEmailGeneratorTest {
	@Test
	public void bithdayMessageForEmployee() {
		Employee john = new Employee("John", "", "2000/01/01", "john@gmail.com");

		Email mail = new BirthdayEmailGenerator().getMessage(john);

		assertEquals("john@gmail.com", mail.recipient);
		assertEquals("Happy Birthday, dear John!", mail.body);
		assertEquals("Happy Birthday!", mail.subject);
	}
}
