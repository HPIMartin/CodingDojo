package dev.schoenberg.codingDojo.birthdayGreetings;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

public class AcceptanceTest {
	private static final String HOST = "localhost";
	private static final String RESOURCE_FILE = "src/main/resources/employee_data.txt";

	private SimpleSmtpServer mailServer;

	@Before
	public void setUp() {
		int freePort = getFreePort();
		mailServer = SimpleSmtpServer.start(freePort);
		Main.HOST = HOST;
		Main.PORT = freePort;
		Main.SOURCEFILE = RESOURCE_FILE;
	}

	private int getFreePort() {
		try (ServerSocket socket = new ServerSocket(0);) {
			return socket.getLocalPort();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@After
	public void tearDown() {
		mailServer.stop();
	}

	@Test
	public void willSendGreetings_whenItsSomebodysBirthday() {
		Main.TODAY = new XDate("2008/10/08");

		Main.main(new String[0]);

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
		Main.TODAY = new XDate("2008/01/01");

		Main.main(new String[0]);

		assertEquals(0, mailServer.getReceivedEmailSize());
	}
}
