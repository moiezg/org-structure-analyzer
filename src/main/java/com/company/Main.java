package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: java -jar org-structure-analyzer.jar <employees.csv>");
            System.exit(1);
        }

        List<String> lines = Files.readAllLines(Paths.get(args[0]));
        Map<Integer, Employee> employees = EmployeeLoader.loadEmployees(lines);
        Employee ceo = employees.get(-1);

        List<Rule> rules = List.of(
                new SalaryRule(),
                new ReportingLineRule()
        );

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees, ceo, rules);
        analyzer.runAllChecks();
    }
}
