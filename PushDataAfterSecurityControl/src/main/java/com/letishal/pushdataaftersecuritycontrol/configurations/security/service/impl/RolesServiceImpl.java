package com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.RolesService;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Roles;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class RolesServiceImpl implements RolesService<Roles> {
    @NonNull
    private JpaRepository<Roles, Long> repository;
    public Optional<Roles> findById(Long id) {return repository.findById(id).filter(e -> !e.getRole().equals("ADMIN"));}
    public Optional<Roles> save(Roles role) {return Optional.of(repository.save(role));}
    public Optional<Roles> update(Roles role) {return Optional.of(repository.save(role));}
    public void remove(Long id) {repository.deleteById(id);}


    //добавить и удалить если достаточно прав


}
