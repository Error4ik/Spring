package org.example.company.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Employee {

    @NotNull(message = "The name cannot be empty.")
    @Size(min = 2, max = 20, message = "The length of employee name should be from 2 to 20 characters")
    private String name;
    @NotNull(message = "The surname cannot be empty.")
    @Size(min = 2, max = 20, message = "The length of the employee surname should be from 2 to 20 characters")
    private String surname;

    @NotNull
    @Min(value = 18, message = "The age must be 18 or older.")
    @Max(value = 65, message = "The age must not be older than 65 years.")
    private int age;

    public Employee() {
    }

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return String.format("Employee {name = %s, surname = %s, age = %d}", name, surname, age);
    }
}
