package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.time.LocalDate;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public class BirthdayService<E extends Message> {
	private final Sender<E> sender;
	private EmployeeRepository repo;
	private MessageFactory<E> messageFactory;
	private BirthdayChecker hasBirthday;

	public BirthdayService(Sender<E> sender, EmployeeRepository repo, MessageFactory<E> messageFactory,
			BirthdayChecker hasBirthday) {
		this.sender = sender;
		this.repo = repo;
		this.messageFactory = messageFactory;
		this.hasBirthday = hasBirthday;
	}

	public void sendGreetings(LocalDate today) {
		repo.getEmployees().stream().filter(e -> hasBirthday.isBirthday(e.birthDate, today))
				.map(messageFactory::getMessage).forEach(sender::sendMessage);
	}
}
