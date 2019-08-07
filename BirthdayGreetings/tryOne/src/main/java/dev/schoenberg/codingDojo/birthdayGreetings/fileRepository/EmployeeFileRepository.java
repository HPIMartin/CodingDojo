package dev.schoenberg.codingDojo.birthdayGreetings.fileRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.schoenberg.codingDojo.birthdayGreetings.core.Employee;
import dev.schoenberg.codingDojo.birthdayGreetings.core.EmployeeRepository;

public class EmployeeFileRepository implements EmployeeRepository {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	private final String fileName;

	public EmployeeFileRepository(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0],
						LocalDate.parse(employeeData[2], FORMATTER), employeeData[3]);
				employees.add(employee);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return employees;
	}
}
