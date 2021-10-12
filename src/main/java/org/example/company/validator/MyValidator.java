package org.example.company.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.domain.Employee;
import org.example.company.domain.Position;
import org.example.company.domain.Salary;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class MyValidator {

    private static final Logger logger = LogManager.getLogger();
    private final Validator validator;

    public MyValidator(Validator validator) {
        this.validator = validator;
    }

    public boolean validateEmployee(Employee employee) {
        Set<ConstraintViolation<Employee>> errors = validator.validate(employee);
        if (errors.size() > 0) {
            errors.forEach(cv -> {
                logger.error(cv.getMessage());
                logger.error(cv.getInvalidValue());
            });
            return false;
        }
        return true;
    }

    public boolean validatePosition(Position position) {
        Set<ConstraintViolation<Position>> errors = validator.validate(position);
        if (errors.size() > 0) {
            errors.forEach(cv -> {
                logger.error(cv.getMessage());
                logger.error(cv.getInvalidValue());
            });
            return false;
        }
        return true;
    }

    public boolean validateSalary(Salary salary) {
        Set<ConstraintViolation<Salary>> errors = validator.validate(salary);
        if (errors.size() > 0) {
            errors.forEach(cv -> {
                logger.error(cv.getMessage());
                logger.error(cv.getInvalidValue());
            });
            return false;
        }
        return true;
    }
}
