package com.company;

import java.util.*;

public class SalaryRule implements Rule {
    @Override
    public List<String> validate(Employee ceo, Map<Integer, Employee> employees) {
        List<String> result = new ArrayList<>();
        for (Employee manager : employees.values()) {
            if (manager.getSubordinates().isEmpty()) continue;

            double avg = manager.getSubordinates().stream()
                    .mapToDouble(Employee::getSalary)
                    .average().orElse(0);

            double min = avg * 1.2;
            double max = avg * 1.5;

            if (manager.getSalary() < min) {
                result.add(manager + " earns " + manager.getSalary() +
                        " but should earn at least " + String.format("%.2f", min) +
                        " (short by " + String.format("%.2f", min - manager.getSalary()) + ")");
            } else if (manager.getSalary() > max) {
                result.add(manager + " earns " + manager.getSalary() +
                        " but should earn at most " + String.format("%.2f", max) +
                        " (excess by " + String.format("%.2f", manager.getSalary() - max) + ")");
            }
        }
        return result;
    }
}
