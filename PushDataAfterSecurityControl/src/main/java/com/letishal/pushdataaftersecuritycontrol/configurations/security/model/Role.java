package com.letishal.pushdataaftersecuritycontrol.configurations.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    Long id;
    String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    Set<Client> clients;

    @Override
    public String getAuthority() {
        return getName();
    }
}

/*
 метод getAuthority() (возвращает имя роли),имя роли должно соответствовать: «ROLE_ИМЯ», например, ROLE_USER.
*/