package com.company;

import java.util.List;
import java.util.Map;

public class EmployeeAnalyzer {
    private final Map<Integer, Employee> employees;
    private final Employee ceo;
    private final List<Rule> rules;

    public EmployeeAnalyzer(Map<Integer, Employee> employees, Employee ceo, List<Rule> rules) {
        this.employees = employees;
        this.ceo = ceo;
        this.rules = rules;
    }

    public void runAllChecks() {
        for (Rule rule : rules) {
            rule.validate(ceo, employees).forEach(System.out::println);
        }
    }
}
