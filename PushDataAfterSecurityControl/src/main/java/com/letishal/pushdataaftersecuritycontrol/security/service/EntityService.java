package com.letishal.pushdataaftersecuritycontrol.security.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EntityService<T, IdType> {
    List<T> findAll();

    Optional<T> save(T entity);

    Optional<T> findById(IdType id);

//    Optional<T> update(T entity);
//    List<T> pushAll(List<T> entities);
//    void remove(IdType id);
}