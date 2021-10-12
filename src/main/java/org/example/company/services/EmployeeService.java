package org.example.company.services;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.storage.EmployeeStorage;
import org.example.company.validator.MyValidator;

import java.util.List;
import java.util.Map;

public class EmployeeService {

    private final MyValidator myValidator;
    private final EmployeeStorage employeeStorage;

    public EmployeeService(MyValidator myValidator, EmployeeStorage employeeStorage) {
        this.myValidator = myValidator;
        this.employeeStorage = employeeStorage;
    }

    public boolean hireEmployee(Position position, Employee employee) {
        if (myValidator.validatePosition(position) && myValidator.validateEmployee(employee)) {
            return employeeStorage.hireEmployee(position, employee);
        }
        return false;
    }

    public boolean dismissEmployee(Position position, Employee employee) {
        if (myValidator.validatePosition(position) && myValidator.validateEmployee(employee)) {
            return employeeStorage.dismissEmployee(position, employee);
        }
        return false;
    }

    public Map<Position, List<Employee>> getPositionEmployeesMap() {
        return employeeStorage.getPositionEmployeesMap();
    }
}
