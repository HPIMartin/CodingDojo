package dev.schoenberg.codingDojo.birthdayGreetings;

import static java.time.LocalDate.*;

import java.time.LocalDate;

import dev.schoenberg.codingDojo.birthdayGreetings.core.BirthdayChecker;
import dev.schoenberg.codingDojo.birthdayGreetings.core.BirthdayService;
import dev.schoenberg.codingDojo.birthdayGreetings.email.BirthdayEmailGenerator;
import dev.schoenberg.codingDojo.birthdayGreetings.email.Email;
import dev.schoenberg.codingDojo.birthdayGreetings.email.EmailSender;
import dev.schoenberg.codingDojo.birthdayGreetings.fileRepository.EmployeeFileRepository;

public class Main {
	public static int PORT = 25;
	public static String HOST = "localhost";
	public static String SOURCEFILE = "employee_data.txt";
	public static LocalDate TODAY = now();

	public static void main(String[] args) {
		EmployeeFileRepository repo = new EmployeeFileRepository(SOURCEFILE);
		EmailSender sender = new EmailSender(HOST, PORT, "sender@here.com");
		BirthdayEmailGenerator mailGen = new BirthdayEmailGenerator();
		BirthdayService<Email> service = new BirthdayService<Email>(sender, repo, mailGen, new BirthdayChecker());
		service.sendGreetings(TODAY);
	}
}
