package synergy.employee.internal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
public class BranchOffice extends Office {
    private HashMap<String, Employee> employees;

    public BranchOffice(String id, String name, String address) {
        super(id, name, address);
        this.employees = new HashMap<>();
    }
}
