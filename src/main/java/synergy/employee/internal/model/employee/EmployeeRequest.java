package synergy.employee.internal.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private String address;
    private String branchOfficeId;

    public EmployeeRequest(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
