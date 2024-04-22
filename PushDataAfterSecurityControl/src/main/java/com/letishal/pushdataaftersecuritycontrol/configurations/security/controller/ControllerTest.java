package com.letishal.pushdataaftersecuritycontrol.configurations.security.controller;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Role;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.ClientServiceImpl;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.RoleServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class ControllerTest {
    @NonNull
    ClientServiceImpl clientService;
    @PostMapping("save")
    public Client addClient(@RequestBody Client client) {return clientService.save(client).orElseThrow(() -> new RuntimeException("Failed to save the client"));}
    @GetMapping("find")
    List<Client> findAll(){return clientService.findAll();}
//    @PostMapping("saveAll")
//    List<Client> pushAll(List<Client> entities){return clientService.pushAll(entities);}
//    @GetMapping("find/{id}")
//    Optional<Client> findById(@PathVariable Long id){return clientService.findById(id);}
//    @PostMapping("update")
//    Optional<Client> update(Client entity){return clientService.update(entity);}
//    @DeleteMapping("delete/{id}")
//    void remove(@PathVariable Long id){clientService.remove(id);}
}
