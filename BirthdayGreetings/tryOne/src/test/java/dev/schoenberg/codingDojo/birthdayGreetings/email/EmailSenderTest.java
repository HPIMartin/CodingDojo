package dev.schoenberg.codingDojo.birthdayGreetings.email;

import static dev.schoenberg.codingDojo.birthdayGreetings.TestHelper.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

public class EmailSenderTest {
	private static final String HOST = "localhost";

	private SimpleSmtpServer mailServer;

	private EmailSender tested;

	@Before
	public void setUp() {
		int freePort = getFreePort();
		mailServer = SimpleSmtpServer.start(freePort);
		tested = new EmailSender(HOST, freePort, "sender@test.com");
	}

	@After
	public void tearDown() {
		mailServer.stop();
	}

	@Test
	public void emailIsSend() {
		Email mail = new Email("subject", "body", "recipient@test.com");

		tested.sendMessage(mail);

		SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmail().next();
		assertEquals("subject", message.getHeaderValue("Subject"));
		assertEquals("body", message.getBody());
		assertEquals("sender@test.com", message.getHeaderValues("From")[0].toString());
		assertEquals("recipient@test.com", message.getHeaderValues("To")[0].toString());
	}
}
