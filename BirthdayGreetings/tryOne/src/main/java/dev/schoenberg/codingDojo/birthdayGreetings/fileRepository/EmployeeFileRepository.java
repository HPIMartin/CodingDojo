package dev.schoenberg.codingDojo.birthdayGreetings.fileRepository;

import static java.time.LocalDate.*;
import static java.util.stream.Collectors.*;

import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.schoenberg.codingDojo.birthdayGreetings.core.EmployeeRepository;
import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;

public class EmployeeFileRepository implements EmployeeRepository {
	private static final String SPLITT_PATTERN = ", ";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	private final Path fileName;
	private final FileReader reader;

	public EmployeeFileRepository(Path fileName, FileReader reader) {
		this.fileName = fileName;
		this.reader = reader;
	}

	@Override
	public List<Employee> getEmployees() {
		return reader.readAllLines(fileName).stream().skip(1).map(this::parseEmployee).collect(toList());
	}

	private Employee parseEmployee(String str) {
		String[] data = str.split(SPLITT_PATTERN);
		return new Employee(data[1], data[0], parse(data[2], FORMATTER), data[3]);
	}
}
