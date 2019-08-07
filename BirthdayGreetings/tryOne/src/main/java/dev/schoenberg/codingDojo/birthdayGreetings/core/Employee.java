package dev.schoenberg.codingDojo.birthdayGreetings.core;

public class Employee {
	public final XDate birthDate;
	public final String lastName;
	public final String firstName;
	public final String email;

	public Employee(String firstName, String lastName, String birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = new XDate(birthDate);
		this.email = email;
	}

	public boolean hasBirthday(XDate today) {
		return today.isBirthday(birthDate);
	}
}
