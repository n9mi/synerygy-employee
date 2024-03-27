package synergy.employee.internal.repository;

import lombok.NoArgsConstructor;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;

import java.util.HashMap;

@NoArgsConstructor
public class BranchOfficeRepository {
    private HashMap<String, BranchOffice> branchOffices;

    public BranchOffice get(String id) {
        return this.branchOffices.get(id);
    }

    public void create(BranchOffice bo) {
        this.branchOffices.put(bo.getId(), bo);
    }

    public boolean isExists(String id) {
        return this.branchOffices.containsKey(id);
    }

    public void delete(BranchOffice bo) {
        this.branchOffices.remove(bo.getId());
    }

    public void addEmployee(BranchOffice bo, Employee e) {
        HashMap<String, Employee> employees = bo.getEmployees();
        employees.put(e.getId(), e);
        bo.setEmployees(employees);
        this.create(bo);
    }

    public boolean isEmployeeExist(BranchOffice bo, String eId) {
        HashMap<String, Employee> employees = bo.getEmployees();
        return employees.containsKey(eId);
    }
}
