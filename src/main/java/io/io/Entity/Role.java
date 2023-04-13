package io.io.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @NotBlank
    private long id;
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    public Role(){

    }

    public Role(RoleName name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
