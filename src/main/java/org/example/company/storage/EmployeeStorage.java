package org.example.company.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.domain.Employee;
import org.example.company.domain.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStorage {

    private static final Logger logger = LogManager.getLogger();
    private final Map<Position, List<Employee>> positionEmployeesMap = new HashMap<>();

    public boolean hireEmployee(Position position, Employee employee) {
        if (!positionEmployeesMap.containsKey(position)) {
            positionEmployeesMap.put(position, new ArrayList<>());
        }
        logger.info(String.format("Employee - %s was hired for the position - %s", employee.getName(), position.getPositionName()));
        position.setEmployeeCount(position.getEmployeeCount() + 1);
        return positionEmployeesMap.get(position).add(employee);
    }

    public boolean dismissEmployee(Position position, Employee employee) {
        if (positionEmployeesMap.containsKey(position)) {
            logger.info(String.format("Employee - %s was dismissed from the position - %s", employee.getName(), position.getPositionName()));
            position.setEmployeeCount(position.getEmployeeCount() - 1);
            return positionEmployeesMap.get(position).remove(employee);
        }
        return false;
    }

    public Map<Position, List<Employee>> getPositionEmployeesMap() {
        return positionEmployeesMap;
    }
}
