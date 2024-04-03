package synergy.employee.internal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Employee {
    private String id;
    private String name;
    private String address;
    private String branchOfficeId;

    public Employee(String name, String address, String branchOfficeId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.branchOfficeId = branchOfficeId;
    }
}
