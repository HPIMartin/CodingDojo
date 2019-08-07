package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.IOException;
import java.net.ServerSocket;

public class TestHelper {
	public static int getFreePort() {
		try (ServerSocket socket = new ServerSocket(0);) {
			return socket.getLocalPort();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
