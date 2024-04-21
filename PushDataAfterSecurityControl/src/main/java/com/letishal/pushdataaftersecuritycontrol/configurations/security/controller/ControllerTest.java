//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//
//import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
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
//public class ControllerTest {
//    @NonNull
//    private ServiceTest service;
//    @PostMapping("/new-user")
//    public String addRole(@RequestBody Client client) {
//        service.addRole(client);
//        return "User is saved";
//    }
//}
package com.letishal.pushdataaftersecuritycontrol.configurations.security.controller;


import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.ClientServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ControllerTest {
    @NonNull
    ClientServiceImpl service;

    @PostMapping("/new-user")
    public String addRole(@RequestBody Client client) {
        service.save(client);
        return "User is saved";
    }
}