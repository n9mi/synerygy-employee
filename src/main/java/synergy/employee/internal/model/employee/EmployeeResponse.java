package synergy.employee.internal.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {
    private String id;
    private String name;
    private String address;
    private String branchOfficeName;
}
