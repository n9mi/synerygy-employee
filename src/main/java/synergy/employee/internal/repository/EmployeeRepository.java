package synergy.employee.internal.repository;

import lombok.NoArgsConstructor;
import synergy.employee.internal.entity.Employee;

import java.util.HashMap;

@NoArgsConstructor
public class EmployeeRepository {
    private HashMap<String, Employee> employees;

    public Employee get(String id) {
        return this.employees.get(id);
    }

    public void create(Employee e) {
        this.employees.put(e.getId(), e);
    }

    public boolean isExists(String id) {
        return this.employees.containsKey(id);
    }

    public void delete(Employee e) {
        this.employees.remove(e.getId());
    }
}
