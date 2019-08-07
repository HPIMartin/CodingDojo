package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.util.List;

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
		List<Employee> employees = repo.getEmployees();
		for (Employee employee : employees) {
			if (employee.isBirthday(today)) {
				E m = messageFactory.getMessage(employee);
				sender.sendMessage(m);
			}
		}
	}
}
