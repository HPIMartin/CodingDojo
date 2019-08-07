package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static java.time.Month.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XDate {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	private final LocalDate date;

	public XDate() {
		date = LocalDate.now();
	}

	public XDate(String yyyyMMdd) {
		date = LocalDate.parse(yyyyMMdd, FORMATTER);
	}

	public boolean isBirthday(XDate birthday) {
		return isSameMonth(birthday) && isSameDayOfMonth(birthday)
				|| isLeapBirthday(birthday) && isLeapBirthdayFallback();
	}

	private boolean isSameMonth(XDate birthday) {
		return date.getMonth() == birthday.date.getMonth();
	}

	private boolean isSameDayOfMonth(XDate birthday) {
		return date.getDayOfMonth() == birthday.date.getDayOfMonth();
	}

	private boolean isLeapBirthday(XDate birthday) {
		return birthday.date.getMonth() == FEBRUARY && birthday.date.getDayOfMonth() == 28;
	}

	private boolean isLeapBirthdayFallback() {
		return date.getMonth() == FEBRUARY && date.getDayOfMonth() == 27;
	}
}
