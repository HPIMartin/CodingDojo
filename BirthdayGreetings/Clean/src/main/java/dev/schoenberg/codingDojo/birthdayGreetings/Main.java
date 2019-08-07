package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {
	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService();
		service.sendGreetings("employee_data.txt", new XDate(), "localhost", 25);
	}
}
