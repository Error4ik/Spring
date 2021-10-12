package org.example.company.services;

import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SalaryServiceTest {

    private final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("spring-context.xml");

    private final SalaryService salaryService = context.getBean(SalaryService.class);

    @Test
    public void whenSetSalaryToPositionShouldReturnTrueThatKeyIsContained() {
        Position position = new Position("HR", 5);
        Salary salary = new Salary(1000);

        salaryService.setSalaryToPosition(position, salary);

        assertTrue(salaryService.getPositionSalaryMap().containsKey(position));
    }

    @Test
    public void whenRecalculateSalaryShouldChangedSalaryForPositions() {
        Position p1 = new Position("HR", 5);
        double initialSalary = 1250;
        Salary s1 = new Salary(initialSalary);
        salaryService.setSalaryToPosition(p1, s1);
        double condition = salaryService.getInflationPerYearAsPercentage();

        salaryService.recalculationSalary();
        Salary actualSalary = salaryService.getPositionSalaryMap().get(p1);

        assertThat(actualSalary.getAmountSalary(), is(recalculateSalary(initialSalary, condition)));
    }

    private double recalculateSalary(double initialSalary, double condition) {
        return Math.round(initialSalary + (initialSalary / 100 * condition));
    }
}