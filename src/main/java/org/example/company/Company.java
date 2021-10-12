package org.example.company;

import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.example.company.services.EmployeeService;
import org.example.company.services.PositionService;
import org.example.company.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Company {

    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final SalaryService salaryService;

    @Autowired
    public Company(EmployeeService employeeService, PositionService positionService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.salaryService = salaryService;
    }

    public void addPosition(Position position) {
        positionService.addPosition(position);
    }

    public List<Position> getPositionSet() {
        return positionService.getPositionList();
    }

    public void setSalaryToPosition(Position position, Salary salary) {
        salaryService.setSalaryToPosition(position, salary);
    }

    public void recalculationSalary() {
        salaryService.recalculationSalary();
    }

    public Map<Position, Salary> getPositionSalaryMap() {
        return salaryService.getPositionSalaryMap();
    }

    public void hireEmployee(Position position, Employee employee) {
        employeeService.hireEmployee(position, employee);
    }

    public void dismissEmployee(Position position, Employee employee) {
        employeeService.dismissEmployee(position, employee);
    }

    public Map<Position, List<Employee>> getPositionEmployeesMap() {
        return employeeService.getPositionEmployeesMap();
    }
}
