package org.example.company.services;

import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.example.company.storage.SalaryStorage;
import org.example.company.validator.MyValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class SalaryServiceTest {

    private final SalaryStorage salaryStorage = mock(SalaryStorage.class);
    private final MyValidator validator = mock(MyValidator.class);
    private final SalaryService salaryService = new SalaryService(validator, salaryStorage);
    private final Position position = mock(Position.class);
    private final Salary salary = mock(Salary.class);

    @Test
    public void whenSetSalaryToPositionShouldReturnTrueThatKeyIsContained() {
        when(validator.validatePosition(any(Position.class))).thenReturn(true);
        when(validator.validateSalary(any(Salary.class))).thenReturn(true);

        salaryService.setSalaryToPosition(position, salary);

        verify(salaryStorage, times(1)).setSalaryToPosition(position, salary);
    }

    @Test
    public void whenRecalculateSalaryShouldCallRecalculateMethodBySalaryStorage() {
        salaryService.recalculationSalary();

        verify(salaryStorage, times(
                1)).recalculationSalary(salaryService.getInflationPerYearAsPercentage());
    }

    @Test
    public void whenPositionSalaryMapShouldReturnMap() {
        when(salaryStorage.getPositionSalaryMap()).thenReturn(new HashMap<>());

        salaryService.getPositionSalaryMap();

        verify(salaryStorage, times(1)).getPositionSalaryMap();
    }
}