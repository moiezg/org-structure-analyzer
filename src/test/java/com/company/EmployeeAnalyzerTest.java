package com.company;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeAnalyzerTest {
    @Test
    void testSalaryViolations() {
        List<String> csv = Arrays.asList(
                "Id,firstName,lastName,salary,managerId",
                "123,Joe,Doe,60000,",
                "124,Martin,Chekov,45000,123",
                "125,Bob,Ronstad,47000,123",
                "300,Alice,Hasacat,50000,124",
                "305,Brett,Hardleaf,34000,300"
        );

        Map<Integer, Employee> employees = EmployeeLoader.loadEmployees(csv);
        Employee ceo = employees.get(-1);

        SalaryRule rule = new SalaryRule();
        List<String> issues = rule.validate(ceo, employees);

        assertTrue(issues.stream().anyMatch(s -> s.contains("Martin Chekov")));
    }

    @Test
    void testReportingLineViolations() {
        List<String> csv = Arrays.asList(
                "Id,firstName,lastName,salary,managerId",
                "123,Joe,Doe,60000,",
                "124,Martin,Chekov,45000,123",
                "300,Alice,Hasacat,50000,124",
                "301,Tom,Tester,40000,300",
                "302,Jill,Junior,30000,301",
                "303,Tina,TooDeep,25000,302"
        );

        Map<Integer, Employee> employees = EmployeeLoader.loadEmployees(csv);
        Employee ceo = employees.get(-1);

        ReportingLineRule rule = new ReportingLineRule();
        List<String> issues = rule.validate(ceo, employees);

        assertTrue(issues.stream().anyMatch(s -> s.contains("Tina TooDeep")));
    }
}
