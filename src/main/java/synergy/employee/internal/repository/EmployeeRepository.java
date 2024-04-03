package synergy.employee.internal.repository;

import lombok.NoArgsConstructor;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class EmployeeRepository {
    public List<Employee> findAll() {
        return new ArrayList<>(Repository.employees.values());
    }

    public Employee findById(String employeeId) {
        return Repository.employees.get(employeeId);
    }

    public List<Employee> findByBranchOfficeId(String branchOfficeId) {
        return Repository.employees.values().stream().filter(employee ->
                employee.getBranchOfficeId().equals(branchOfficeId)).collect(Collectors.toList());
    }

    public boolean isExists(String employeeId) {
        return Repository.employees.containsKey(employeeId);
    }

    public boolean isExistsInBranchOffice(String employeeId, String branchOfficeId) {
        Employee employee = this.findById(employeeId);

        return employee != null && Repository.branchOffices.containsKey(employee.getBranchOfficeId()) &&
                employee.getBranchOfficeId().equals(branchOfficeId);
    }

    public void create(Employee employee) {
        Repository.employees.put(employee.getId(), employee);
    }

    public void update(String employeeId, Employee employee) {
        Repository.employees.put(employeeId, employee);
    }

    public void delete(Employee employee) {
        Repository.employees.remove(employee.getId());
    }
}
