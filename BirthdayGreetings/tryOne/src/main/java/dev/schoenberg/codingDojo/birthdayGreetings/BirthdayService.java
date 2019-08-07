package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BirthdayService {
	private final EmailSender sender;

	public BirthdayService(EmailSender sender) {
		this.sender = sender;
	}

	public void sendGreetings(String fileName, XDate xDate) {
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				if (employee.isBirthday(xDate)) {
					String recipient = employee.email;
					String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.firstName);
					String subject = "Happy Birthday!";
					sender.sendMessage(subject, body, recipient);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
