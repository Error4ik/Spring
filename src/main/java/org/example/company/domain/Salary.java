package org.example.company.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Salary {

    @NotNull
    @Min(value = 500, message = "The salary cannot be less than 300.")
    private double amountSalary;

    public Salary() {
    }

    public Salary(double amountSalary) {
        this.amountSalary = amountSalary;
    }

    public double getAmountSalary() {
        return amountSalary;
    }

    public void setAmountSalary(double amountSalary) {
        this.amountSalary = amountSalary;
    }

    @Override
    public String toString() {
        return String.format("Salary {amountSalary = %s}", amountSalary);
    }
}
