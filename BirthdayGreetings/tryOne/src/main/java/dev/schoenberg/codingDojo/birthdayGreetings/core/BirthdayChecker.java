package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.time.LocalDate;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Birthday;

public interface BirthdayChecker {

	boolean isBirthday(Birthday date, LocalDate today);

}
