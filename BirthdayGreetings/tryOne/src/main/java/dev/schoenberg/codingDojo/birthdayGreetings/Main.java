package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {
	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(new EmailSender("localhost", 25, "sender@here.com"));
		service.sendGreetings("employee_data.txt", new XDate());
	}
}
