package dev.schoenberg.codingDojo.birthdayGreetings.email;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public class Email extends Message {
	public final String subject;
	public final String body;
	public final String recipient;

	public Email(String subject, String body, String recipient) {
		this.subject = subject;
		this.body = body;
		this.recipient = recipient;
	}
}
