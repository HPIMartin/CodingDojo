package dev.schoenberg.codingDojo.birthdayGreetings.core;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public interface Sender<E extends Message> {
	void sendMessage(E message);
}
