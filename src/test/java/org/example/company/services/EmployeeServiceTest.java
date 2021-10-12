package org.example.company.services;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.storage.EmployeeStorage;
import org.example.company.validator.MyValidator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class EmployeeServiceTest {

    private final EmployeeStorage employeeStorage = mock(EmployeeStorage.class);
    private final MyValidator validator = mock(MyValidator.class);
    private final EmployeeService employeeService = new EmployeeService(validator, employeeStorage);
    private final Position position = mock(Position.class);
    private final Employee employee = mock(Employee.class);

    @Test
    public void whenHiredEmployeeOnPositionShouldReturnTrue() {
        when(validator.validatePosition(any(Position.class))).thenReturn(true);
        when(validator.validateEmployee(any(Employee.class))).thenReturn(true);
        when(employeeStorage.hireEmployee(any(Position.class), any(Employee.class))).thenReturn(true);

        boolean actualValue = employeeService.hireEmployee(position, employee);

        assertTrue(actualValue);
        verify(employeeStorage, times(1)).hireEmployee(position, employee);
    }

    @Test
    public void whenEmployeeDismissedFromHisPositionShouldReturnTrue() {
        when(validator.validatePosition(any(Position.class))).thenReturn(true);
        when(validator.validateEmployee(any(Employee.class))).thenReturn(true);
        when(employeeStorage.dismissEmployee(any(Position.class), any(Employee.class))).thenReturn(true);

        boolean actualValue = employeeService.dismissEmployee(position, employee);

        assertTrue(actualValue);
        verify(employeeStorage, times(1)).dismissEmployee(position, employee);
    }

    @Test
    public void getPositionEmployeesMap() {
        when(employeeStorage.getPositionEmployeesMap()).thenReturn(new HashMap<>());

        employeeService.getPositionEmployeesMap();

        verify(employeeStorage, times(1)).getPositionEmployeesMap();
    }
}