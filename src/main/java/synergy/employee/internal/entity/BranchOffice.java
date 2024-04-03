package synergy.employee.internal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchOffice extends Office {
    public BranchOffice(String name, String address) {
        super(name, address);
    }
}
