//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//public class MyRolesDetails implements UserDetails {
//    private final Roles role;
//
//    public MyRolesDetails(Roles role) {
//        this.role = role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays.stream(role.getRole().split(", ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return role.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return role.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}








