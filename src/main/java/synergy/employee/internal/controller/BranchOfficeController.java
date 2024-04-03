package synergy.employee.internal.controller;

import lombok.AllArgsConstructor;
import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.model.office.AssignEmployeeToBranchOfficeRequest;
import synergy.employee.internal.model.office.BranchOfficeIdRequest;
import synergy.employee.internal.model.office.BranchOfficeResponse;
import synergy.employee.internal.model.office.CreateBranchOfficeRequest;
import synergy.employee.internal.service.BranchOfficeService;

import java.util.List;

@AllArgsConstructor
public class BranchOfficeController {
    private final BranchOfficeService branchOfficeService;

    public List<BranchOfficeResponse> getAll() {
        return this.branchOfficeService.findAll();
    }

    public BranchOfficeResponse getById(String branchOfficeId) {
        return this.branchOfficeService.findById(new BranchOfficeIdRequest(branchOfficeId));
    }

    public List<EmployeeResponse> getEmployeeFromBranchOffice(String branchOfficeId) {
        BranchOfficeIdRequest request = new BranchOfficeIdRequest(branchOfficeId);

        return this.branchOfficeService.findEmployeeFromBranchOffice(request);
    }

    public void create(String name, String address) {
        CreateBranchOfficeRequest request = new CreateBranchOfficeRequest(name, address);

        this.branchOfficeService.create(request);
    }

    public void assignEmployee(String employeeId, String branchOfficeId) {
        this.branchOfficeService.assignEmployee(new AssignEmployeeToBranchOfficeRequest(employeeId, branchOfficeId));
    }
}
