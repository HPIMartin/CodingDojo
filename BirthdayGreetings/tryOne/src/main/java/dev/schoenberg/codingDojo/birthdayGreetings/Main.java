package dev.schoenberg.codingDojo.birthdayGreetings;

import static java.time.LocalDate.now;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import dev.schoenberg.codingDojo.birthdayGreetings.core.BirthdayService;
import dev.schoenberg.codingDojo.birthdayGreetings.core.SimpleBirthdayChecker;
import dev.schoenberg.codingDojo.birthdayGreetings.email.BirthdayEmailGenerator;
import dev.schoenberg.codingDojo.birthdayGreetings.email.Email;
import dev.schoenberg.codingDojo.birthdayGreetings.email.EmailSender;
import dev.schoenberg.codingDojo.birthdayGreetings.fileRepository.EmployeeFileRepository;
import dev.schoenberg.codingDojo.birthdayGreetings.fileRepository.SimpleFileReader;

public class Main {
    public static int PORT = 25;
    public static String HOST = "localhost";
    public static String SOURCEFILE = "employee_data.txt";
    public static LocalDate TODAY = now();

    public static void main(String[] args) {
	// TODO: Move finding place to dedicated type
	final URL resource = Main.class.getClassLoader().getResource(SOURCEFILE);
	Path path;
	try {
	    path = Paths.get(resource.toURI());
	} catch (final URISyntaxException e) {
	    throw new RuntimeException(e);
	}
	final EmployeeFileRepository repo = new EmployeeFileRepository(path, new SimpleFileReader());
	final EmailSender sender = new EmailSender(HOST, PORT, "sender@here.com");
	final BirthdayEmailGenerator mailGen = new BirthdayEmailGenerator();
	final BirthdayService<Email> service = new BirthdayService<>(sender, repo, mailGen,
		new SimpleBirthdayChecker());

	service.sendGreetings(TODAY);
    }
}
