package com.company;

import java.util.List;
import java.util.Map;

public interface Rule {
    List<String> validate(Employee ceo, Map<Integer, Employee> employees);
}
