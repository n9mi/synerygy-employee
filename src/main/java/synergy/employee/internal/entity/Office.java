package synergy.employee.internal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Office {
    private String id;
    private String name;
    private String address;

    public Office(String name, String address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
    }
}
