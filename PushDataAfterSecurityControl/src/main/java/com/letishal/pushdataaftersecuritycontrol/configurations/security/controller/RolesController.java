package com.letishal.pushdataaftersecuritycontrol.configurations.security.controller;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Roles;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.RolesService;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.RolesServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping()
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
public class RolesController implements RolesService<Roles> {
    RolesServiceImpl service;
    @GetMapping("/{id}")
    @ResponseBody
    @Override
    public Optional<Roles> findById(@PathVariable Long id) {return service.findById(id);}

    @PostMapping("/{role}")
    @ResponseBody
    @Override
    public Optional<Roles> save(@PathVariable Roles role) {return service.save(role);}
    @PostMapping("/{role}")
    @ResponseBody
    @Override
    public Optional<Roles> update(@PathVariable Roles role) {return service.save(role);}

    @DeleteMapping("/{id}")
    @ResponseBody
    @Override
    public void remove(@PathVariable Long id) {service.remove(id);}

}
