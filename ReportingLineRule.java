package com.company;

import java.util.*;

public class ReportingLineRule implements Rule {
    @Override
    public List<String> validate(Employee ceo, Map<Integer, Employee> employees) {
        List<String> result = new ArrayList<>();
        dfsCheck(ceo, 0, result);
        return result;
    }

    private void dfsCheck(Employee e, int depth, List<String> result) {
        if (depth > 4) {
            result.add(e + " has " + depth + " managers above (exceeds by " + (depth - 4) + ")");
        }
        for (Employee sub : e.getSubordinates()) {
            dfsCheck(sub, depth + 1, result);
        }
    }
}
