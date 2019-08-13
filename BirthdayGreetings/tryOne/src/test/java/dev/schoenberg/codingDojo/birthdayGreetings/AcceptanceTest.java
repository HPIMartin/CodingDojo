package dev.schoenberg.codingDojo.birthdayGreetings;

import static dev.schoenberg.codingDojo.birthdayGreetings.TestHelper.getFreePort;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;

public class AcceptanceTest {
    private static final String HOST = "localhost";
    private static final String RESOURCE_FILE = "employee_test_data.txt";

    private SimpleSmtpServer mailServer;

    @Before
    public void setUp() {
	final int freePort = getFreePort();
	mailServer = SimpleSmtpServer.start(freePort);
	Main.HOST = HOST;
	Main.PORT = freePort;
	Main.SOURCEFILE = RESOURCE_FILE;
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
