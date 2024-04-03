package synergy.employee.internal.repository;

import lombok.NoArgsConstructor;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class BranchOfficeRepository {
    public List<BranchOffice> findAll() {
        return new ArrayList<>(Repository.branchOffices.values());
    }

    public BranchOffice findById(String branchOfficeId) {
        return Repository.branchOffices.get(branchOfficeId);
    }

    public boolean isExists(String branchOfficeId) {
        return Repository.branchOffices.containsKey(branchOfficeId);
    }

    public void create(BranchOffice branchOffice) {
        Repository.branchOffices.put(branchOffice.getId(), branchOffice);
    }

    public void update(String branchOfficeId, BranchOffice branchOffice) {
        Repository.branchOffices.put(branchOfficeId, branchOffice);
    }

    public void delete(BranchOffice branchOffice) {
        Repository.branchOffices.remove(branchOffice.getId());
    }

    public void assignEmployeeToBranchOffice(Employee employee, BranchOffice branchOffice) {
        employee.setBranchOfficeId(branchOffice.getId());
        Repository.employees.put(employee.getId(), employee);
    }
}
