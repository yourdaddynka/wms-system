package com.letishal.pushdataaftersecuritycontrol.configurations.security.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;


@Table
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String role;
    @Column(unique = true, nullable = false)
    @Size(min = 4, max = 20, message = "Диапазон символов от 4 до 20")
    String userNickName;
    @Size(min = 8, message = "не меньше 8 символов")
    String userPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;
}
/*
Для использования в Security необходимо, чтобы он implements UserDetails(для метода getAuthorities).
FetchType.EAGER - «жадная» загрузка, т.е. список ролей загружается вместе с пользователем сразу (не ждет пока к нему обратятся)
*/
