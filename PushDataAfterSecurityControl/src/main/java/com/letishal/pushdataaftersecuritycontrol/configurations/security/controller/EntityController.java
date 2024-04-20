package com.letishal.pushdataaftersecuritycontrol.configurations.security.controller;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.EntityService;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.UserServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("api/v1/")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
public class EntityController implements EntityService<Client> {
    UserServiceImpl service;

    @ResponseBody
    @Override
    public Optional<Client> findById(@PathVariable Long id) {return service.findById(id);}


    @ResponseBody
    @Override
    public List<Client> findAll() { return service.findAll();}

    @ResponseBody
    @Override
    public List<Client> pushAll(List<Client> entities) {return service.pushAll(entities);}

    @ResponseBody
    @Override
    public Optional<Client> save(@PathVariable Client role) {return service.save(role);}
    @ResponseBody
    @Override
    public Optional<Client> update(@PathVariable Client role) {return service.update(role);}

    @ResponseBody
    @Override
    public void remove(@PathVariable Long id) {service.remove(id);}
}



