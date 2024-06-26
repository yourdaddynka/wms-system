package com.letishal.pushdataaftersecuritycontrol.security.service.impl;

import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.security.repository.ClientRepository;
import com.letishal.pushdataaftersecuritycontrol.security.repository.EntityRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientServiceImpl extends EntityServiceImpl<Client, Long> {
    EntityRepository<Client, Long> clientRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public ClientServiceImpl(EntityRepository<Client, Long> clientRepository, PasswordEncoder bCryptPasswordEncoder) {
        super(clientRepository);
        this.clientRepository = clientRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public Optional<Client> findById(Long id) {
        return super.findById(id)
                .filter(e -> e.getRoles()
                        .stream()
                        .anyMatch(ex -> ex.getName().equals("ROLE_ADMIN"))
                );
    }
    @Override
    public Optional<Client> save(Client entity) {
        Optional<Client> client = ((ClientRepository) clientRepository).findByUserNickName(entity.getUserNickName());
        if (client.isPresent()) {return Optional.empty();}
        entity.setUserPassword(bCryptPasswordEncoder.encode(entity.getUserPassword()));
        return Optional.of(clientRepository.save(entity));
    }


}
