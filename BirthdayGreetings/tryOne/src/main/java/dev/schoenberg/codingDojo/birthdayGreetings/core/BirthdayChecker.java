package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static java.time.Month.*;

import java.time.LocalDate;

public class BirthdayChecker {
	public boolean isBirthday(LocalDate birthday, LocalDate today) {
		return isSameMonth(birthday, today) && isSameDayOfMonth(birthday, today)
				|| isLeapBirthday(birthday) && isLeapBirthdayFallback(today);
	}

	private boolean isSameMonth(LocalDate birthday, LocalDate today) {
		return today.getMonth() == birthday.getMonth();
	}

	private boolean isSameDayOfMonth(LocalDate birthday, LocalDate today) {
		return today.getDayOfMonth() == birthday.getDayOfMonth();
	}

	private boolean isLeapBirthday(LocalDate birthday) {
		return birthday.getMonth() == FEBRUARY && birthday.getDayOfMonth() == 28;
	}

	private boolean isLeapBirthdayFallback(LocalDate today) {
		return today.getMonth() == FEBRUARY && today.getDayOfMonth() == 27;
	}
}
