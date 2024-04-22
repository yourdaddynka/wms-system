//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//
//public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new MyRolesDetailsService();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("api/v1/proxy/welcome", "api/v1/apps/welcome", "api/v1/new-user").permitAll()
//                        .requestMatchers("api/v1/proxy/users/**", "api/v1/apps/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                        .requestMatchers("api/v1/proxy/posts/**", "api/v1/apps/posts/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS")
//                        .requestMatchers("api/v1/proxy/albums/**", "api/v1/apps/albums/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS")
//                        .requestMatchers("api/v1/proxy/photos/**", "api/v1/apps/photos/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_ALBUMS", "ROLE_PHOTOS")
//                        .requestMatchers("api/v1/proxy/comments/**", "api/v1/apps/comments/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS", "ROLE_COMMENTS")
//                        .requestMatchers(HttpMethod.GET, "api/v1/proxy/**", "api/v1/apps/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_VIEWER")
//                        .requestMatchers(HttpMethod.POST, String.valueOf(HttpMethod.PUT), "api/v1/proxy/**", "api/v1/apps/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_POSTS_EDITOR")
//                        .requestMatchers("api/v1/apps/**", "api/v1/proxy/**").authenticated()
//                )
//                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//                .build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService());
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//}