package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Birthday;

public class BirthdayCheckerTest {
	private BirthdayChecker tested;
	private Birthday birthday;
	private LocalDate today;
	private boolean result;

	@Before
	public void setup() {
		tested = new BirthdayChecker();
	}

	@Test
	public void sameDay() {
		arrangeBirthDay(2000, JANUARY, 1);
		arrangeToday(2000, JANUARY, 1);

		act();

		assertBirthday();
	}

	@Test
	public void differentYear() {
		arrangeBirthDay(2000, JANUARY, 1);
		arrangeToday(2001, JANUARY, 1);

		act();

		assertBirthday();
	}

	@Test
	public void differentDay() {
		arrangeBirthDay(2000, JANUARY, 1);
		arrangeToday(2000, JANUARY, 2);

		act();

		assertNotBirthday();
	}

	@Test
	public void differentMonth() {
		arrangeBirthDay(2000, JANUARY, 1);
		arrangeToday(2000, FEBRUARY, 1);

		act();

		assertNotBirthday();
	}

	@Test
	public void bornOnLeapYearDay() {
		arrangeBirthDay(2004, FEBRUARY, 28);
		arrangeToday(2005, FEBRUARY, 27);

		act();

		assertBirthday();
	}

	private void arrangeBirthDay(int year, Month month, int day) {
		birthday = new Birthday(of(year, month, day));
	}

	private void arrangeToday(int year, Month month, int day) {
		today = of(year, month, day);
	}

	private void act() {
		result = tested.isBirthday(birthday, today);
	}

	private void assertBirthday() {
		assertTrue(result);
	}

	private void assertNotBirthday() {
		assertFalse(result);
	}
}
