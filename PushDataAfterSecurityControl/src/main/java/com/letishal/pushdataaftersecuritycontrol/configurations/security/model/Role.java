package com.letishal.pushdataaftersecuritycontrol.configurations.security.model;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    Long id;
    String name;
    public Role() {}

    @Override
    public String getAuthority() {
        return getName();
    }
}
