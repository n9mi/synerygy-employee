package synergy.employee.internal.repository;

import lombok.Getter;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;

import java.util.HashMap;

@Getter
public class Repository {
    protected static final HashMap<String, BranchOffice> branchOffices = new HashMap<>();
    protected static final HashMap<String, Employee> employees = new HashMap<>();
}
