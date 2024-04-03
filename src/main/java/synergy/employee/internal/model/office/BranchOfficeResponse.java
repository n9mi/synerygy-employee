package synergy.employee.internal.model.office;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BranchOfficeResponse {
    String id;
    String name;
    String address;
}
