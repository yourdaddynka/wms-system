package com.letishal.pushdataaftersecuritycontrol.security.config;
import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.security.model.Role;
import com.letishal.pushdataaftersecuritycontrol.security.repository.ClientRepository;
import com.letishal.pushdataaftersecuritycontrol.security.repository.RoleRepository;
import com.letishal.pushdataaftersecuritycontrol.security.service.MyRolesDetailsService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@PropertySource("classpath:ADMIN.properties")
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyRolesDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/save", "api/v1/find").permitAll()
                        .requestMatchers(HttpMethod.GET, "TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers(HttpMethod.POST, String.valueOf(HttpMethod.PUT), "TEST").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/v1/**").authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public ApplicationRunner applicationRunner(ClientRepository clientRepository, RoleRepository roleRepository, Environment env) {
        return args -> {
            String adminNickName = env.getProperty("admin.username");
            String adminPassword = env.getProperty("admin.password");
            Set<Role> roles = new HashSet<>();
            String[] rolesArray = env.getProperty("admin.roles", "ROLE_USER").split(",");
            System.out.println("adminPassword = " + adminPassword);
            System.out.println("adminNickName = " + adminNickName);
            System.out.println(Arrays.toString(rolesArray));
            for (String roleName : rolesArray) {
                Optional<Role> optionalRole = roleRepository.findByName(roleName.trim());
                Role roleToAdd = optionalRole.orElseGet(() -> {
                    Role newRole = new Role(roleName);
                    return roleRepository.save(newRole);
                });
                roles.add(roleToAdd);
            }
            if (clientRepository.findByUserNickName(adminNickName).isEmpty()) {
                Client admin = new Client();
                admin.setUserNickName(adminNickName);
                admin.setUserPassword(passwordEncoder().encode(adminPassword));
                admin.setRoles(roles);
                clientRepository.save(admin);
            }
        };
    }
}
