//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyRolesDetailsService implements UserDetailsService {
//    @Autowired
//    private RolesRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Roles> role = repository.findByName(username);
//        return role.map(MyRolesDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
//    }
//}