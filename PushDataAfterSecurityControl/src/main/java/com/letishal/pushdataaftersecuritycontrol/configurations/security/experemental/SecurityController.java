//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1")
//public class SecurityController {
//    @NonNull
//    private SecurityService service;
//
//    @PostMapping("/new-user")
//    public String addRole(@RequestBody Roles role) {
//        service.addRole(role);
//        return "User is saved";
//    }
//}