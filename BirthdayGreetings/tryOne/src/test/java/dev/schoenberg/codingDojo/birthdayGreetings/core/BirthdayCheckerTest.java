package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class BirthdayCheckerTest {
	private BirthdayChecker tested;

	@Before
	public void setup() {
		tested = new BirthdayChecker();
	}

	@Test
	public void sameDay() {
		LocalDate birthday = of(2000, JANUARY, 1);
		LocalDate today = of(2000, JANUARY, 1);

		boolean result = tested.isBirthday(birthday, today);

		assertTrue(result);
	}

	@Test
	public void differentYear() {
		LocalDate birthday = of(2000, JANUARY, 1);
		LocalDate today = of(2001, JANUARY, 1);

		boolean result = tested.isBirthday(birthday, today);

		assertTrue(result);
	}

	@Test
	public void differentDay() {
		LocalDate birthday = of(2000, JANUARY, 1);
		LocalDate today = of(2000, JANUARY, 2);

		boolean result = tested.isBirthday(birthday, today);

		assertFalse(result);
	}

	@Test
	public void differentMonth() {
		LocalDate birthday = of(2000, JANUARY, 1);
		LocalDate today = of(2000, FEBRUARY, 1);

		boolean result = tested.isBirthday(birthday, today);

		assertFalse(result);
	}

	@Test
	public void bornOnLeapYearDay() {
		LocalDate birthday = of(2004, FEBRUARY, 28);
		LocalDate today = of(2005, FEBRUARY, 27);

		boolean result = tested.isBirthday(birthday, today);

		assertTrue(result);
	}
}
