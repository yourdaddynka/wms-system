package com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Role;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.repository.EntityRepository;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.EntityService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl  implements EntityService<Role> {
    @NonNull
    EntityRepository<Role,Long> repository;
    public List<Role> findAll() {return repository.findAll();}
    public Optional<Role> findById(Long id) {return repository.findById(id);}
    public Optional<Role> save(Role role) {return Optional.of(repository.save(role));}
    public List<Role> pushAll(List<Role> entities) {return repository.saveAll(entities);}

    public Optional<Role> update(Role role) {return Optional.of(repository.save(role));}
    public void remove(Long id) {repository.deleteById(id);}
}
