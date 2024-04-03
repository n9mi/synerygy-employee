package synergy.employee.internal.controller;

import lombok.AllArgsConstructor;
import synergy.employee.internal.model.employee.EmployeeRequest;
import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.service.EmployeeService;

import java.util.List;

@AllArgsConstructor
public class EmployeeController {
    public final EmployeeService employeeService;

    public List<EmployeeResponse> getAll() {
        return this.employeeService.findAll();
    }

    public void create(String name, String address) {
        this.employeeService.create(new EmployeeRequest(name, address));
    }
}
