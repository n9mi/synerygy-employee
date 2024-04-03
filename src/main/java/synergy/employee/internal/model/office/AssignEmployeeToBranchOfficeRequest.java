package synergy.employee.internal.model.office;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssignEmployeeToBranchOfficeRequest {
    private String employeeId;
    private String branchOfficeId;
}
