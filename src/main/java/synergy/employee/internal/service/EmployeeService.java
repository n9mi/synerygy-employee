package synergy.employee.internal.service;

import synergy.employee.internal.model.employee.EmployeeRequest;
import synergy.employee.internal.model.employee.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponse> findAll();
    public void create(EmployeeRequest request);
}
