package com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.repository.EntityRepository;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.EntityService;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements EntityService<Client>, UserDetailsService {
    @NonNull
    EntityRepository<Client,Long> repository;
    @Override
    public List<Client> findAll() {return repository.findAll();}
    @Override
    public Optional<Client> findById(Long id) {return repository.findById(id).filter(e -> !e.getRole().equals("ADMIN"));}
    @Override
    public Optional<Client> save(Client role) {return Optional.of(repository.save(role));}
    @Override
    public List<Client> pushAll(List<Client> entities) {return repository.saveAll(entities);}
    @Override
    public Optional<Client> update(Client role) {return Optional.of(repository.save(role));}
    @Override
    public void remove(Long id) {repository.deleteById(id);}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    //добавить и удалить если достаточно прав
}



