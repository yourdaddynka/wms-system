package com.letishal.pushdataaftersecuritycontrol.configurations.security.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;


@Table
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client implements UserDetails {
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
    @Override
    public String getUsername() {return getUserNickName();}

    @Override
    public String getPassword() {return getUserPassword();}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return getRoles();}
    @Override
    public boolean isAccountNonExpired() {return true;}
    @Override
    public boolean isAccountNonLocked() {return true;}
    @Override
    public boolean isCredentialsNonExpired() {return true;}
    @Override
    public boolean isEnabled() {return true;}
}
/*
Для использования в Security необходимо, чтобы он implements UserDetails(для метода getAuthorities).
FetchType.EAGER - «жадная» загрузка, т.е. список ролей загружается вместе с пользователем сразу (не ждет пока к нему обратятся)
*/

/*
@Table
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String role;
    @Column(unique = true, nullable = false)
    @Size(min = 4, max = 20, message = "Диапазон символов от 4 до 20")
    String userName;
    @Size(min = 8, message = "не меньше 8 символов")
    String password;
}
*/