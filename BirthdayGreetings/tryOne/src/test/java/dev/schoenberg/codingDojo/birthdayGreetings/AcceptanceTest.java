package dev.schoenberg.codingDojo.birthdayGreetings;

import static dev.schoenberg.codingDojo.birthdayGreetings.TestHelper.*;
import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;

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
		Main.SOURCEFILE = Paths.get(RESOURCE_FILE);
	}

	@After
	public void tearDown() {
		mailServer.stop();
	}

	@Test
	public void smokeTest() {
		Main.TODAY = LocalDate.of(2008, Month.OCTOBER, 8);

		Main.main(new String[0]);

		assertEquals(1, mailServer.getReceivedEmailSize());
	}
}
