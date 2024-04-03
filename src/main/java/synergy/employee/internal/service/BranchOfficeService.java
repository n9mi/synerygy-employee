package synergy.employee.internal.service;

import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.model.office.AssignEmployeeToBranchOfficeRequest;
import synergy.employee.internal.model.office.BranchOfficeIdRequest;
import synergy.employee.internal.model.office.BranchOfficeResponse;
import synergy.employee.internal.model.office.CreateBranchOfficeRequest;

import java.util.List;

public interface BranchOfficeService {
    public List<BranchOfficeResponse> findAll();
    public BranchOfficeResponse findById(BranchOfficeIdRequest request);
    public List<EmployeeResponse> findEmployeeFromBranchOffice(BranchOfficeIdRequest request);
    public void create(CreateBranchOfficeRequest request);
    public void assignEmployee(AssignEmployeeToBranchOfficeRequest request);
}
