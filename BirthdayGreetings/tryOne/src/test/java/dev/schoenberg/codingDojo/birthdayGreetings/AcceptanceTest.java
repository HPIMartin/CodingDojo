package dev.schoenberg.codingDojo.birthdayGreetings;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;

import dev.schoenberg.codingDojo.birthdayGreetings.core.XDate;

public class AcceptanceTest {
	private static final String HOST = "localhost";
	private static final String RESOURCE_FILE = "src/test/resources/employee_data.txt";

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
	public void smokeTest() {
		Main.TODAY = new XDate("2008/10/08");

		Main.main(new String[0]);

		assertEquals(1, mailServer.getReceivedEmailSize());
	}
}
