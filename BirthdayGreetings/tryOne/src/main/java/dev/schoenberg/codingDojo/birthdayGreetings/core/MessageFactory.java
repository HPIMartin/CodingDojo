package dev.schoenberg.codingDojo.birthdayGreetings.core;

public interface MessageFactory<E extends Message> {
	E getMessage(Employee employee);
}
