package dev.schoenberg.codingDojo.birthdayGreetings.core;

import java.util.List;

import dev.schoenberg.codingDojo.birthdayGreetings.domain.Employee;

public interface EmployeeRepository {
	List<Employee> getEmployees();
}
