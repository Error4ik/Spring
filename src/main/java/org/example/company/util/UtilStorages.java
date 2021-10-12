package org.example.company.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;
import org.example.company.services.EmployeeService;
import org.example.company.services.PositionService;
import org.example.company.services.SalaryService;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class UtilStorages {

    private static final Logger logger = LogManager.getLogger();
    private final static String SEPARATOR = "--------------------";
    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final SalaryService salaryService;

    public UtilStorages(EmployeeService employeeService, PositionService positionService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.salaryService = salaryService;
    }

    public void fillingStorages() {
        Position it = new Position("DEVELOPER", 40);
        Position tester = new Position("TESTER", 20);
        Position hr = new Position("HR", 7);
        Position dispatcher = new Position("DISPATCHER", 10);
        Position engineer = new Position("ENGINEER", 10);
        Position manager = new Position("MANAGER", 5);
        Position security = new Position("SECURITY", 10);
        Position administrator = new Position("ADMINISTRATOR", 2);
        Position cleaning = new Position("CLEANING", 5);
        Position courier = new Position("COURIER", 5);

        positionService.addPosition(it);
        positionService.addPosition(tester);
        positionService.addPosition(hr);
        positionService.addPosition(dispatcher);
        positionService.addPosition(engineer);
        positionService.addPosition(manager);
        positionService.addPosition(security);
        positionService.addPosition(administrator);
        positionService.addPosition(cleaning);
        positionService.addPosition(courier);

        salaryService.setSalaryToPosition(it, new Salary(5732));
        salaryService.setSalaryToPosition(tester, new Salary(4656));
        salaryService.setSalaryToPosition(hr, new Salary(4267));
        salaryService.setSalaryToPosition(dispatcher, new Salary(3500));
        salaryService.setSalaryToPosition(engineer, new Salary(7421));
        salaryService.setSalaryToPosition(manager, new Salary(7300));
        salaryService.setSalaryToPosition(security, new Salary(4100));
        salaryService.setSalaryToPosition(administrator, new Salary(8900));
        salaryService.setSalaryToPosition(cleaning, new Salary(3900));
        salaryService.setSalaryToPosition(courier, new Salary(2900));

        for (Position position : positionService.getPositionList()) {
            int random = (int) ((Math.random() * 10) + (Math.random() * 10));
            int nameRandom = (int) ((Math.random() * 1000) + (Math.random() * 1000));
            Employee employee = new Employee("Name" + nameRandom, "Surname" + nameRandom, 18 + random);
            employeeService.hireEmployee(position, employee);
        }

        printPositionSet();
    }

    public Employee createEmployee() {
        int ageRandom = (int) ((Math.random() * 9) + (Math.random() * 15));
        int nameRandom = (int) ((Math.random() * 1000) + (Math.random() * 1000));
        return new Employee("Name" + nameRandom, "Surname" + nameRandom, 18 + ageRandom);
    }

    public Position getRandomPosition() {
        List<Position> positions = positionService.getPositionList();
        return positions.get(new Random().nextInt(positions.size()));
    }

    public void printPositionSet() {
        logger.info(String.format("%s %s %s", SEPARATOR, "Position List", SEPARATOR));
        positionService.getPositionList().forEach(logger::info);
        logger.info(String.format("%s %s %s", SEPARATOR, SEPARATOR, SEPARATOR));
    }

    public void printPositionSalary() {
        Map<Position, Salary> positionSalaryMap = salaryService.getPositionSalaryMap();
        logger.info(String.format("%s %s %s", SEPARATOR, "Position Salary", SEPARATOR));
        for (Map.Entry<Position, Salary> positionSalaryEntry : positionSalaryMap.entrySet()) {
            logger.info(String.format(
                    "%s - salary = %s",
                    positionSalaryEntry.getKey().getPositionName(),
                    positionSalaryEntry.getValue().getAmountSalary()));
        }
        logger.info(String.format("%s %s %s", SEPARATOR, SEPARATOR, SEPARATOR));
    }

    public void printEmployeeForEachPosition() {
        Map<Position, List<Employee>> positionEmployeesMap = employeeService.getPositionEmployeesMap();
        for (Map.Entry<Position, List<Employee>> positionListEntry : positionEmployeesMap.entrySet()) {
            logger.info(String.format(
                    "%s - %s",
                    positionListEntry.getKey().getPositionName(),
                    positionListEntry.getValue().stream().map(Employee::getName).collect(Collectors.toList())));
        }
    }

    public void changeEmployeeYear() {
        Map<Position, List<Employee>> positionEmployeesMap = employeeService.getPositionEmployeesMap();
        for (List<Employee> value : positionEmployeesMap.values()) {
            for (Employee employee : value) {
                employee.setAge(employee.getAge() + 1);
            }
        }
    }

    public Employee getRandomEmployeeByPosition(Position position) {
        List<Employee> employees = employeeService.getPositionEmployeesMap().get(position);
        if (employees.size() > 0) {
            return employees.get(new Random().nextInt(employees.size()));
        } else {
            return null;
        }
    }
}
