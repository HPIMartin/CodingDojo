package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {
	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		EmployeeFileRepository repo = new EmployeeFileRepository("employee_data.txt");
		EmailSender sender = new EmailSender("localhost", 25, "sender@here.com");
		BirthdayService service = new BirthdayService(sender, repo);
		service.sendGreetings(new XDate());
	}
}
