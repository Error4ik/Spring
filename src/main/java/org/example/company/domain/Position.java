package org.example.company.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Position {

    @NotNull
    @Size(min = 2, max = 200, message = "The length of the position name should be from 2 to 200 characters")
    private String positionName;
    @Min(1)
    @Max(50)
    private int employeeLimit;
    private int employeeCount;

    public Position() {
    }

    public Position(String positionName, int employeeLimit) {
        this.positionName = positionName;
        this.employeeLimit = employeeLimit;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getEmployeeLimit() {
        return employeeLimit;
    }

    public void setEmployeeLimit(int employeeLimit) {
        this.employeeLimit = employeeLimit;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(positionName, position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionName);
    }

    @Override
    public String toString() {
        return String.format(
                "Position {positionName = %s, employeeLimit = %s, employeeCount = %s}",
                positionName,
                employeeLimit,
                employeeCount);
    }
}
