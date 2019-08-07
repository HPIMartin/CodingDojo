package dev.schoenberg.codingDojo.birthdayGreetings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

public class AcceptanceTest {
	private static final String HOST = "localhost";
	private static final String RESOURCE_FILE = "src/main/resources/employee_data.txt";
	private static final int NONSTANDARD_PORT = 9999;

	private BirthdayService birthdayService;
	private SimpleSmtpServer mailServer;

	@Before
	public void setUp() {
		mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
		birthdayService = new BirthdayService(new EmailSender(HOST, NONSTANDARD_PORT, "a@b.c"));
	}

	@After
	public void tearDown() throws Exception {
		mailServer.stop();
		Thread.sleep(200);
	}

	@Test
	public void willSendGreetings_whenItsSomebodysBirthday() {
		birthdayService.sendGreetings(RESOURCE_FILE, new XDate("2008/10/08"));

		assertEquals(1, mailServer.getReceivedEmailSize());

		SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmail().next();
		String[] recipients = message.getHeaderValues("To");
		assertEquals(1, recipients.length);
		assertEquals("john.doe@foobar.com", recipients[0].toString());
		assertEquals("Happy Birthday, dear John!", message.getBody());
		assertEquals("Happy Birthday!", message.getHeaderValue("Subject"));
	}

	@Test
	public void willNotSendEmailsWhenNobodysBirthday() {
		birthdayService.sendGreetings(RESOURCE_FILE, new XDate("2008/01/01"));

		assertEquals(0, mailServer.getReceivedEmailSize());
	}
}
