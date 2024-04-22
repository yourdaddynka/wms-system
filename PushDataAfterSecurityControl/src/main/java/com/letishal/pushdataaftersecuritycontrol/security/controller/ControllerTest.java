package com.letishal.pushdataaftersecuritycontrol.security.controller;
import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.security.service.impl.ClientServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
