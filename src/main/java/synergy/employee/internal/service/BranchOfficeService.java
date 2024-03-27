package synergy.employee.internal.service;

import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.entity.Employee;
import synergy.employee.internal.repository.BranchOfficeRepository;
import synergy.employee.internal.repository.EmployeeRepository;

import java.util.HashMap;

public class BranchOfficeService {
    private final BranchOfficeRepository branchOfficeRepository;
    private final EmployeeRepository employeeRepository;

    public BranchOfficeService(BranchOfficeRepository branchOfficeRepository, EmployeeRepository employeeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
        this.employeeRepository = employeeRepository;
    }

    public BranchOffice get(String id) {
        return this.branchOfficeRepository.get(id);
    }

    public void create(BranchOffice bo) throws RuntimeException {
        if (this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office already exists");
        }

        this.branchOfficeRepository.create(bo);
    }

    public void update(BranchOffice bo) throws RuntimeException {
        if (!this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office does not exist");
        }

        this.branchOfficeRepository.create(bo);
    }

    public void delete(BranchOffice bo) throws RuntimeException {
        if (!this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office does not exist");
        }

        this.branchOfficeRepository.delete(bo);
    }

    public void addEmployee(String boId, String eId) {
        if (!this.employeeRepository.isExists(eId)) {
            throw new RuntimeException("employee does not exist");
        }
        if (!this.branchOfficeRepository.isExists(boId)) {
            throw new RuntimeException("branch office does not exist");
        }
        Employee e = employeeRepository.get(eId);
        BranchOffice bo = this.get(boId);
        if (this.branchOfficeRepository.isEmployeeExist(bo, eId)) {
            throw new RuntimeException("employee already exists in branch office");
        }
        branchOfficeRepository.addEmployee(bo, e);
    }

}
