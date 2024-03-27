package synergy.employee.internal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String id;
    private String name;
    private String address;
}
