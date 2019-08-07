package dev.schoenberg.codingDojo.birthdayGreetings.fileRepository;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;

public class EmployeeFileRepositoryTest {
	private List<String> lines;
	private EmployeeFileRepository tested;

	@Before
	public void setup() {
		lines = new ArrayList<>();
		tested = new EmployeeFileRepository(null, p -> lines);
	}

	@Test
	public void headlineIsSkipped() {
		lines.add("headline");

		List<Employee> result = tested.getEmployees();

		assertEquals(0, result.size());
	}

	@Test
	public void employeeIsParsed() {
		lines.add("headline");
		lines.add("Last, First, 2000/01/01, first@last.com");

		List<Employee> result = tested.getEmployees();

		Employee e = result.get(0);
		assertEquals("First", e.firstName);
		assertEquals("Last", e.lastName);
		assertEquals(of(2000, JANUARY, 1), e.birthDate);
		assertEquals("first@last.com", e.email);
	}
}
