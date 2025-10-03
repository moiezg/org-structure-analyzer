package com.company;

import java.util.*;

public class EmployeeLoader {
    public static Map<Integer, Employee> loadEmployees(List<String> lines) {
        Map<Integer, Employee> employees = new HashMap<>();
        Employee ceo = null;

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            int id = Integer.parseInt(parts[0].trim());
            String first = parts[1].trim();
            String last = parts[2].trim();
            double salary = Double.parseDouble(parts[3].trim());
            Integer managerId = (parts.length > 4 && !parts[4].trim().isEmpty())
                    ? Integer.parseInt(parts[4].trim())
                    : null;

            Employee emp = new Employee(id, first, last, salary, managerId);
            employees.put(id, emp);
        }

        for (Employee e : employees.values()) {
            if (e.getManagerId() == null) {
                ceo = e;
            } else {
                employees.get(e.getManagerId()).getSubordinates().add(e);
            }
        }

        employees.put(-1, ceo);
        return employees;
    }
}
