package dev.schoenberg.codingDojo.birthdayGreetings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class XDate {
	private final Date date;

	public XDate() {
		date = new Date();
	}

	public XDate(String yyyyMMdd) {
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isSameDay(XDate anotherDate) {
		return anotherDate.getDay() == this.getDay() && anotherDate.getMonth() == this.getMonth();
	}

	private int getDay() {
		return getPartOfDate(GregorianCalendar.DAY_OF_MONTH);
	}

	private int getMonth() {
		return 1 + getPartOfDate(GregorianCalendar.MONTH);
	}

	private int getPartOfDate(int part) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(part);
	}
}
