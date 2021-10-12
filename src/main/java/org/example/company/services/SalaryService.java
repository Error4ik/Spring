package org.example.company.services;

import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.example.company.storage.SalaryStorage;
import org.example.company.validator.MyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SalaryService {

    @Value("${salary.inflationPerYear}")
    private double inflationPerYearAsPercentage;
    private final MyValidator myValidator;
    private final SalaryStorage storage;

    @Autowired
    public SalaryService(MyValidator myValidator, SalaryStorage storage) {
        this.myValidator = myValidator;
        this.storage = storage;
    }

    public void setSalaryToPosition(Position position, Salary salary) {
        if (myValidator.validatePosition(position) && myValidator.validateSalary(salary)) {
            storage.setSalaryToPosition(position, salary);
        }
    }

    public void recalculationSalary() {
        storage.recalculationSalary(inflationPerYearAsPercentage);
    }

    public Map<Position, Salary> getPositionSalaryMap() {
        return storage.getPositionSalaryMap();
    }

    public double getInflationPerYearAsPercentage() {
        return inflationPerYearAsPercentage;
    }

    public void setInflationPerYearAsPercentage(double inflationPerYearAsPercentage) {
        this.inflationPerYearAsPercentage = inflationPerYearAsPercentage;
    }
}
