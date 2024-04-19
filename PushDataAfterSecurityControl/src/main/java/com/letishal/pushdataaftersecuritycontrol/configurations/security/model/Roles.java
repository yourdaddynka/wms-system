package com.letishal.pushdataaftersecuritycontrol.configurations.security.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import static jakarta.persistence.GenerationType.IDENTITY;


@Table
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Roles {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String role;
    @Column(unique = true,nullable = false)
    String userName;
    String password;
}
