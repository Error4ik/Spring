package org.example.company.services;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EmployeeServiceTest {

    private final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("spring-context.xml");

    private final EmployeeService employeeService = context.getBean(EmployeeService.class);

    @Test
    public void whenHiredEmployeeOnPositionShouldReturnTrue() {
        Position position = new Position("CLEANING", 10);
        Employee employee = new Employee("John", "Doe", 30);

        boolean actualValue = employeeService.hireEmployee(position, employee);

        assertTrue(actualValue);
    }

    @Test
    public void whenEmployeeDismissedFromHisPositionShouldReturnTrue() {
        Position position = new Position("CLEANING", 10);
        Employee employee = new Employee("John", "Doe", 30);
        employeeService.hireEmployee(position, employee);

        boolean actualValue = employeeService.dismissEmployee(position, employee);
        List<Employee> employees = employeeService.getPositionEmployeesMap().get(position);

        assertTrue(actualValue);
        assertThat(employees.size(), is(0));
    }

    @Test
    public void getPositionEmployeesMap() {
        Position position = new Position("CLEANING", 10);
        Employee employee = new Employee("John", "Doe", 30);
        employeeService.hireEmployee(position, employee);

        Map<Position, List<Employee>> actualValue = employeeService.getPositionEmployeesMap();

        assertTrue(actualValue.containsKey(position));
    }
}