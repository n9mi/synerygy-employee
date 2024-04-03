package synergy.employee.internal.service;

import lombok.AllArgsConstructor;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;
import synergy.employee.internal.model.employee.EmployeeRequest;
import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.repository.BranchOfficeRepository;
import synergy.employee.internal.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BranchOfficeRepository branchOfficeRepository;

    public List<EmployeeResponse> findAll() {
        return this.employeeRepository.findAll().stream().map(entity -> {
            String branchOfficeName = "";
            if (entity.getBranchOfficeId() != null) {
                BranchOffice branchOffice = this.branchOfficeRepository.findById(entity.getBranchOfficeId());
                branchOfficeName = branchOffice.getName();
            }

            return new EmployeeResponse(entity.getId(), entity.getName(), entity.getAddress(), branchOfficeName);
        }).collect(Collectors.toList());
    }

    public void create(EmployeeRequest request) {
        this.employeeRepository.create(new Employee(request.getName(), request.getAddress(), request.getBranchOfficeId()));
    }
}
