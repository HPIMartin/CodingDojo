package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.util.List;

import dev.schoenberg.codingDojo.birthdayGreetings.email.EmailSender;
import dev.schoenberg.codingDojo.birthdayGreetings.fileRepository.EmployeeFileRepository;

public class BirthdayService {
	private final EmailSender sender;
	private EmployeeFileRepository repo;

	public BirthdayService(EmailSender sender, EmployeeFileRepository repo) {
		this.sender = sender;
		this.repo = repo;
	}

	public void sendGreetings(XDate today) {
		List<Employee> employees = repo.getEmployees();
		for (Employee employee : employees) {
			if (employee.isBirthday(today)) {
				String recipient = employee.email;
				String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.firstName);
				String subject = "Happy Birthday!";
				sender.sendMessage(subject, body, recipient);
			}
		}
	}
}
