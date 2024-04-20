package com.letishal.pushdataaftersecuritycontrol.configurations.security.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EntityService<T> {
    List<T> findAll();
    List<T> pushAll(List<T> entities);
    Optional<T> save(T entity);
    Optional<T> findById(Long id);
    Optional<T> update(T entity);
    void remove(Long id);
}