package com.letishal.pushdataaftersecuritycontrol.configurations.security.service;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Roles;

import java.util.Optional;

public interface RolesService<T>{
    public Optional<T> findById(Long id);
    public Optional<T> save(Roles role);
    public Optional<T> update(Roles role);
    public void remove(Long id);
}
