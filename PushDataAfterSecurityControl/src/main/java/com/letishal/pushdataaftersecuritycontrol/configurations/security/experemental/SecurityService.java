//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class SecurityService {
//    private RolesRepository repository;
//    private PasswordEncoder passwordEncoder;
//
//    public void addRole(Roles role) {
//        role.setPassword(passwordEncoder.encode(role.getPassword()));
//        repository.save(role);
//    }
//}