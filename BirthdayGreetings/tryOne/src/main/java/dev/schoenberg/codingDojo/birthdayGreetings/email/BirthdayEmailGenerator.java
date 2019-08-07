package dev.schoenberg.codingDojo.birthdayGreetings.email;

import dev.schoenberg.codingDojo.birthdayGreetings.core.MessageFactory;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;

public class BirthdayEmailGenerator implements MessageFactory<Email> {
	@Override
	public Email getMessage(Employee employee) {
		String recipient = employee.email;
		String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.firstName);
		String subject = "Happy Birthday!";
		return new Email(subject, body, recipient);
	}
}
