package org.example.company.validator;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.junit.Test;

import javax.validation.Validator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class MyValidatorTest {

    private final Validator validator = mock(Validator.class);
    private final MyValidator myValidator = new MyValidator(validator);
    private final Set hashSet = mock(HashSet.class);
    private final Position position = mock(Position.class);
    private final Employee employee = mock(Employee.class);
    private final Salary salary = mock(Salary.class);

    @Test
    public void whenValidateEmployeeWithValidEmployeeShouldBeReturnTrue() {
        when(validator.validate(any(Employee.class))).thenReturn(new HashSet<>());

        boolean actualValue = myValidator.validateEmployee(employee);

        assertTrue(actualValue);
        verify(validator, times(1)).validate(employee);
    }

    @Test
    public void whenValidateEmployeeWithNotValidEmployeeShouldBeReturnFalse() {
        when(validator.validate(any(Employee.class))).thenReturn(hashSet);
        when(hashSet.size()).thenReturn(1);

        boolean actualValue = myValidator.validateEmployee(employee);

        assertFalse(actualValue);
        verify(validator, times(1)).validate(employee);
    }

    @Test
    public void whenValidatePositionWithValidPositionShouldBeReturnTrue() {
        when(validator.validate(any(Position.class))).thenReturn(new HashSet<>());

        boolean actualValue = myValidator.validatePosition(position);

        assertTrue(actualValue);
        verify(validator, times(1)).validate(position);
    }

    @Test
    public void whenValidatePositionWithNotValidPositionShouldBeReturnFalse() {
        when(validator.validate(any(Position.class))).thenReturn(hashSet);
        when(hashSet.size()).thenReturn(1);

        boolean actualValue = myValidator.validatePosition(position);

        assertFalse(actualValue);
        verify(validator, times(1)).validate(position);
    }

    @Test
    public void whenValidateSalaryWithValidSalaryShouldBeReturnTrue() {
        when(validator.validate(any(Salary.class))).thenReturn(new HashSet<>());

        boolean actualValue = myValidator.validateSalary(salary);

        assertTrue(actualValue);
        verify(validator, times(1)).validate(salary);
    }

    @Test
    public void whenValidateSalaryWithNotValidSalaryShouldBeReturnFalse() {
        when(validator.validate(any(Salary.class))).thenReturn(hashSet);
        when(hashSet.size()).thenReturn(1);

        boolean actualValue = myValidator.validateSalary(salary);

        assertFalse(actualValue);
        verify(validator, times(1)).validate(salary);
    }

}