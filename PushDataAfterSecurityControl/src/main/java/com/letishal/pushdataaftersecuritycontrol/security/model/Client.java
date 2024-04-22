package com.letishal.pushdataaftersecuritycontrol.security.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    Set<Role> roles;
}