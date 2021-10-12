package org.example.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.config.SpringConfig;
import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.util.UtilStorages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    private static final Logger logger = LogManager.getLogger();
    private final static String SEPARATOR = "--------------------";
    private final static AnnotationConfigApplicationContext CONTEXT = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final static UtilStorages UTIL_STORAGES = CONTEXT.getBean(UtilStorages.class);
    private final static Company company = CONTEXT.getBean(Company.class);
    private final static int MONTHS_PER_YEAR = 12;
    private final static int YEARS = 10;

    public static void main(String[] args) {
        UTIL_STORAGES.fillingStorages();
        for (int i = 0; i < YEARS; i++) {
            logger.info(String.format("%s %d %s", SEPARATOR, 2010 + i, SEPARATOR));
            for (int j = 1; j <= MONTHS_PER_YEAR; j++) {
                actionDuringTheYear(j);
            }
            actionPerYear();
        }
        CONTEXT.close();
    }

    private static void actionDuringTheYear(int j) {
        company.hireEmployee(UTIL_STORAGES.getRandomPosition(), UTIL_STORAGES.createEmployee());
        if (j % 6 == 0) {
            Position position = UTIL_STORAGES.getRandomPosition();
            Employee employee = UTIL_STORAGES.getRandomEmployeeByPosition(position);
            while (employee == null) {
                position = UTIL_STORAGES.getRandomPosition();
                employee = UTIL_STORAGES.getRandomEmployeeByPosition(position);
            }
            company.dismissEmployee(position, employee);
        }
    }

    private static void actionPerYear() {
        logger.info(String.format("%s %s %s", SEPARATOR, "Annual salary indexation!!!", SEPARATOR));
        company.recalculationSalary();
        UTIL_STORAGES.changeEmployeeYear();
        UTIL_STORAGES.printPositionSet();
        UTIL_STORAGES.printPositionSalary();
//        UTIL_STORAGES.printEmployeeForEachPosition();
    }
}
