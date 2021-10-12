package org.example.company.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SalaryStorage {

    private static final Logger logger = LogManager.getLogger();
    private final Map<Position, Salary> positionSalaryMap = new HashMap<>();

    public void setSalaryToPosition(Position position, Salary salary) {
        logger.info(String.format("Salary is set - %s for position - %s", salary, position.getPositionName()));
        positionSalaryMap.put(position, salary);
    }

    public void recalculationSalary(double inflationPerYearAsPercentage) {
        positionSalaryMap
                .values()
                .forEach(s -> s.setAmountSalary(Math.round(s.getAmountSalary() +
                        (s.getAmountSalary() / 100 * inflationPerYearAsPercentage)))
                );

        logger.info(String.format("Salaries increased by %s%%", inflationPerYearAsPercentage));
    }

    public Map<Position, Salary> getPositionSalaryMap() {
        return positionSalaryMap;
    }
}
