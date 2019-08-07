package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static java.time.Month.*;

import java.time.LocalDate;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Birthday;

public class BirthdayChecker {
	public boolean isBirthday(Birthday date, LocalDate today) {
		return isSameMonth(date, today) && isSameDayOfMonth(date, today)
				|| isLeapBirthday(date) && isLeapBirthdayFallback(today);
	}

	private boolean isSameMonth(Birthday birthday, LocalDate today) {
		return today.getMonth() == birthday.date.getMonth();
	}

	private boolean isSameDayOfMonth(Birthday birthday, LocalDate today) {
		return today.getDayOfMonth() == birthday.date.getDayOfMonth();
	}

	private boolean isLeapBirthday(Birthday birthday) {
		return birthday.date.getMonth() == FEBRUARY && birthday.date.getDayOfMonth() == 28;
	}

	private boolean isLeapBirthdayFallback(LocalDate today) {
		return today.getMonth() == FEBRUARY && today.getDayOfMonth() == 27;
	}
}
