package dev.schoenberg.codingDojo.birthdayGreetings.core;

public class BirthdayService<E extends Message> {
	private final Sender<E> sender;
	private EmployeeRepository repo;
	private MessageFactory<E> messageFactory;

	public BirthdayService(Sender<E> sender, EmployeeRepository repo, MessageFactory<E> messageFactory) {
		this.sender = sender;
		this.repo = repo;
		this.messageFactory = messageFactory;
	}

	public void sendGreetings(XDate today) {
		repo.getEmployees().stream().filter(e -> e.isBirthday(today)).map(messageFactory::getMessage)
				.forEach(sender::sendMessage);
	}
}
