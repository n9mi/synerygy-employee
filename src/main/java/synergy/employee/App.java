package synergy.employee;

import synergy.employee.internal.controller.BranchOfficeController;
import synergy.employee.internal.controller.EmployeeController;
import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.model.employee.EmployeeResponse;
import synergy.employee.internal.model.office.BranchOfficeResponse;
import synergy.employee.internal.repository.BranchOfficeRepository;
import synergy.employee.internal.repository.EmployeeRepository;
import synergy.employee.internal.service.BranchOfficeService;
import synergy.employee.internal.service.BranchOfficeServiceImpl;
import synergy.employee.internal.service.EmployeeService;
import synergy.employee.internal.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Setup repositories
        BranchOfficeRepository branchOfficeRepository = new BranchOfficeRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();

        // Setup services
        BranchOfficeService branchOfficeService = new BranchOfficeServiceImpl(branchOfficeRepository, employeeRepository);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, branchOfficeRepository);

        // Setup controller
        BranchOfficeController branchOfficeController = new BranchOfficeController(branchOfficeService);
        EmployeeController employeeController = new EmployeeController(employeeService);

        branchOfficeController.create("Kantor Cabang A", "Kota A");
        branchOfficeController.create("Kantor Cabang B", "Kota B");

        employeeController.create("Employee 1", "Kota A");
        employeeController.create("Employee 2", "Kota A");
        employeeController.create("Employee 3", "Kota B");
        employeeController.create("Employee 4", "Kota B");

        List<BranchOfficeResponse> branchOffices = branchOfficeController.getAll();
        List<EmployeeResponse> employees = employeeController.getAll();

        branchOfficeController.assignEmployee(employees.get(0).getId(), branchOffices.get(0).getId());
        branchOfficeController.assignEmployee(employees.get(1).getId(), branchOffices.get(0).getId());
        branchOfficeController.assignEmployee(employees.get(2).getId(), branchOffices.get(1).getId());
        branchOfficeController.assignEmployee(employees.get(3).getId(), branchOffices.get(1).getId());


        System.out.printf("Employee from branch office %s\n", branchOffices.get(0).getName());
        for (EmployeeResponse employee: branchOfficeController.getEmployeeFromBranchOffice(branchOffices.get(0)
                .getId())) {
            System.out.printf("Name : %s Address : %s\n", employee.getName(), employee.getAddress());
        }

        System.out.printf("Employee from branch office %s\n", branchOffices.get(1).getName());
        for (EmployeeResponse employee: branchOfficeController.getEmployeeFromBranchOffice(branchOffices.get(1)
                .getId())) {
            System.out.printf("Name : %s Address : %s\n", employee.getName(), employee.getAddress());
        }
    }
}
