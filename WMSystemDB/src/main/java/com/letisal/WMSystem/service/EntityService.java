package com.letisal.WMSystem.service;

import java.util.List;
import java.util.Optional;

public interface EntityService<T>{
    List<T> findAll();

    List<T> pushAll(List<T> entities);

    Optional<T> save(T entity);

    Optional<T> findById(Long id);

    Optional<T> update(T entity);

    void remove(Long id);
}
