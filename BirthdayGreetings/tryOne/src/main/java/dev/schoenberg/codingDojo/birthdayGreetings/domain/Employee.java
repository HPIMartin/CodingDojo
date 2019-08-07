package dev.schoenberg.codingDojo.birthdayGreetings.domain;

public class Employee {
	public final Birthday birthDate;
	public final String lastName;
	public final String firstName;
	public final String email;

	public Employee(String firstName, String lastName, Birthday birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
	}
}
