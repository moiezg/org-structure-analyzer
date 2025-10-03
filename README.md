# Code Assignment 106

## Overview
This project analyzes an organization's structure:
1. **Salary rules**: A manager must earn at least 20% and at most 50% more than the average salary of their direct subordinates.  
2. **Reporting line rules**: No employee should have more than 4 managers above them.  

---

## Design Highlights
- **Testability**: Rules are isolated, easily unit tested.  
- **Simplicity**: Clean POJOs, straightforward logic.  
- **Abstraction**: Validation behind `Rule` interface.  
- **Extensibility**: Add new rules without touching existing code.  
- **Patterns**:  
  - Composite (employee hierarchy)  
  - Strategy (rules)  
  - SOLID (SRP, OCP, DIP especially)  

---

## Running
```bash
mvn clean package
java -cp target/code-assignment-106-1.0-SNAPSHOT.jar com.company.Main employees.csv
```

---

## Example Output
```
=== Salary Rule Violations ===
Martin Chekov (ID 124) earns 45000 but should earn at least 47000.00 (short by 2000.00)
Joe Doe (ID 123) earns 60000 but should earn at most 55500.00 (excess by 4500.00)

=== Reporting Line Violations ===
Brett Hardleaf (ID 305) has 5 managers above (exceeds by 1)
```

---

## Tests
Run tests with:
```bash
mvn test
```
