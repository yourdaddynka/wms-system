package com.letishal.pushdataaftersecuritycontrol.configurations.security.config;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.MyRolesDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

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
                        .requestMatchers("TEST", "api/v1/apps/welcome", "api/v1/new-user").permitAll()
                        .requestMatchers("TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                        .requestMatchers("TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS")
                        .requestMatchers("TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS")
                        .requestMatchers("TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS", "ROLE_PHOTOS")
                        .requestMatchers("TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS", "ROLE_COMMENTS")
                        .requestMatchers(HttpMethod.GET, "TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_VIEWER")
                        .requestMatchers(HttpMethod.POST, String.valueOf(HttpMethod.PUT), "TEST").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_EDITOR")
                        .requestMatchers("TEST").authenticated()
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
}
