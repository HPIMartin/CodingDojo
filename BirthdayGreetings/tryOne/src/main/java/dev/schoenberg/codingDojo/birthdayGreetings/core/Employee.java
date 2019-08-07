package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.time.LocalDate;

public class Employee {
	public final LocalDate birthDate;
	public final String lastName;
	public final String firstName;
	public final String email;

	public Employee(String firstName, String lastName, LocalDate birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
	}
}
