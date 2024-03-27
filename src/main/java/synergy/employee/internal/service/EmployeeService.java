package synergy.employee.internal.service;

import synergy.employee.internal.entity.Employee;
import synergy.employee.internal.repository.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee get(String id) {
        return this.employeeRepository.get(id);
    }

    public void create(Employee e) throws RuntimeException {
        if (this.employeeRepository.isExists(e.getId())) {
            throw new RuntimeException("employee already exists");
        }

        this.employeeRepository.create(e);
    }

    public void update(Employee e) throws RuntimeException {
        if (!this.employeeRepository.isExists(e.getId())) {
            throw new RuntimeException("employee does not exist");
        }

        this.employeeRepository.create(e);
    }

    public void delete(Employee e) throws RuntimeException {
        if (!this.employeeRepository.isExists(e.getId())) {
            throw new RuntimeException("employee does not exist");
        }

        this.employeeRepository.delete(e);
    }
}
