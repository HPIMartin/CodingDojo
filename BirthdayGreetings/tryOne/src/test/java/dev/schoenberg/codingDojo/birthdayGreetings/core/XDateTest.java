package dev.schoenberg.codingDojo.birthdayGreetings.core;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.core.XDate;

public class XDateTest {
	@Test
	public void isSameDate() {
		XDate date = new XDate("2000/01/01");
		XDate notSameYear = new XDate("2001/01/01");
		XDate notSameDay = new XDate("2000/01/02");
		XDate notSameMonth = new XDate("2000/02/01");

		assertTrue(date.isSameDay(notSameYear));
		assertFalse(date.isSameDay(notSameDay));
		assertFalse(date.isSameDay(notSameMonth));
	}
}
