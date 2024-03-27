package synergy.employee.internal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Office {
    private String id;
    private String name;
    private String address;
}
