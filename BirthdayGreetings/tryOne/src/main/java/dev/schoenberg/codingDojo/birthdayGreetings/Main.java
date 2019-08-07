package dev.schoenberg.codingDojo.birthdayGreetings;

import dev.schoenberg.codingDojo.birthdayGreetings.core.BirthdayService;
import dev.schoenberg.codingDojo.birthdayGreetings.core.EmployeeRepository;
import dev.schoenberg.codingDojo.birthdayGreetings.core.Sender;
import dev.schoenberg.codingDojo.birthdayGreetings.core.XDate;
import dev.schoenberg.codingDojo.birthdayGreetings.email.EmailSender;
import dev.schoenberg.codingDojo.birthdayGreetings.fileRepository.EmployeeFileRepository;

public class Main {
	public static int PORT = 25;
	public static String HOST = "localhost";
	public static String SOURCEFILE = "employee_data.txt";
	public static XDate TODAY = new XDate();

	public static void main(String[] args) {
		EmployeeRepository repo = new EmployeeFileRepository(SOURCEFILE);
		Sender sender = new EmailSender(HOST, PORT, "sender@here.com");
		BirthdayService service = new BirthdayService(sender, repo);
		service.sendGreetings(TODAY);
	}
}
