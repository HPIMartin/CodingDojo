package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class XDateTest {
	@Test
	public void sameDay() {
		XDate birthday = new XDate("2000/01/01");
		XDate today = new XDate("2000/01/01");

		boolean result = today.isBirthday(birthday);

		assertTrue(result);
	}

	@Test
	public void differentYear() {
		XDate birthday = new XDate("2000/01/01");
		XDate today = new XDate("2001/01/01");

		boolean result = today.isBirthday(birthday);

		assertTrue(result);
	}

	@Test
	public void differentDay() {
		XDate birthday = new XDate("2000/01/01");
		XDate today = new XDate("2000/01/02");

		boolean result = today.isBirthday(birthday);

		assertFalse(result);
	}

	@Test
	public void differentMonth() {
		XDate birthday = new XDate("2000/01/01");
		XDate today = new XDate("2000/02/01");

		boolean result = today.isBirthday(birthday);

		assertFalse(result);
	}

	@Test
	public void bornOnLeapYearDay() {
		XDate birthday = new XDate("2004/02/28");
		XDate today = new XDate("2005/02/27");

		boolean result = today.isBirthday(birthday);

		assertTrue(result);
	}
}
