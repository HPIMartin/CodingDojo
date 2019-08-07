package dev.schoenberg.codingDojo.birthdayGreetings.core;

public interface Sender<E extends Message> {
	void sendMessage(E message);
}
