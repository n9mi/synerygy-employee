package synergy.employee.internal.service;

import lombok.AllArgsConstructor;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;
import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.model.office.AssignEmployeeToBranchOfficeRequest;
import synergy.employee.internal.model.office.BranchOfficeResponse;
import synergy.employee.internal.model.office.CreateBranchOfficeRequest;
import synergy.employee.internal.model.office.BranchOfficeIdRequest;
import synergy.employee.internal.repository.BranchOfficeRepository;
import synergy.employee.internal.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BranchOfficeServiceImpl implements BranchOfficeService {
    private final BranchOfficeRepository branchOfficeRepository;
    private final EmployeeRepository employeeRepository;

    public List<BranchOfficeResponse> findAll() {
        return this.branchOfficeRepository.findAll().stream().map(entity ->
                new BranchOfficeResponse(entity.getId(), entity.getName(), entity.getAddress())
        ).collect(Collectors.toList());
    }

    public BranchOfficeResponse findById(BranchOfficeIdRequest request) {
        BranchOffice branchOfficeEntity = this.branchOfficeRepository.findById(request.getBranchOfficeId());

        return new BranchOfficeResponse(branchOfficeEntity.getId(), branchOfficeEntity.getName(),
                branchOfficeEntity.getAddress());
    }

    public List<EmployeeResponse> findEmployeeFromBranchOffice(BranchOfficeIdRequest request) {
        BranchOffice branchOffice = this.branchOfficeRepository.findById(request.getBranchOfficeId());

        return this.employeeRepository.findByBranchOfficeId(request.getBranchOfficeId()).stream().map(entity ->
                new EmployeeResponse(entity.getId(), entity.getName(), entity.getAddress(), branchOffice.getName())
        ).collect(Collectors.toList());
    }

    public void create(CreateBranchOfficeRequest request) {
        this.branchOfficeRepository.create(new BranchOffice(request.getName(), request.getAddress()));
    }

    public void assignEmployee(AssignEmployeeToBranchOfficeRequest request) {
        Employee employee = this.employeeRepository.findById(request.getEmployeeId());
        BranchOffice branchOffice = this.branchOfficeRepository.findById(request.getBranchOfficeId());
        this.branchOfficeRepository.assignEmployeeToBranchOffice(employee, branchOffice);
    }
}
