package dev.schoenberg.codingDojo.birthdayGreetings.core;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Message;

public interface MessageFactory<E extends Message> {
	E getMessage(Employee employee);
}
