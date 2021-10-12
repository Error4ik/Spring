package org.example.company.validator;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyValidatorTest {

    private final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("spring-context.xml");

    private final MyValidator validator = context.getBean(MyValidator.class);

    @Test
    public void whenValidateEmployeeWithValidEmployeeShouldBeReturnTrue() {
        Employee employee = new Employee("John", "Doe", 20);

        boolean actualValue = validator.validateEmployee(employee);

        assertTrue(actualValue);
    }

    @Test
    public void whenValidateEmployeeWithNotValidEmployeeShouldBeReturnFalse() {
        Employee employee = new Employee(null, "D", 17);

        boolean actualValue = validator.validateEmployee(employee);

        assertFalse(actualValue);
    }

    @Test
    public void whenValidatePositionWithValidPositionShouldBeReturnTrue() {
        Position position = new Position("DEVELOPER", 20);

        boolean actualValue = validator.validatePosition(position);

        assertTrue(actualValue);
    }

    @Test
    public void whenValidatePositionWithNotValidPositionShouldBeReturnFalse() {
        Position position = new Position("D", 20);

        boolean actualValue = validator.validatePosition(position);

        assertFalse(actualValue);
    }

    @Test
    public void whenValidateSalaryWithValidSalaryShouldBeReturnTrue() {
        Salary salary = new Salary(700);

        boolean actualValue = validator.validateSalary(salary);

        assertTrue(actualValue);
    }

    @Test
    public void whenValidateSalaryWithNotValidSalaryShouldBeReturnFalse() {
        Salary salary = new Salary(200);

        boolean actualValue = validator.validateSalary(salary);

        assertFalse(actualValue);
    }

}