package org.selection_classes;

import java.util.Objects;

public class MaxSalaryWorker {
    String name;
    Integer salary;

    public MaxSalaryWorker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaxSalaryWorker)) return false;
        MaxSalaryWorker that = (MaxSalaryWorker) o;
        return Objects.equals(name, that.name) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
