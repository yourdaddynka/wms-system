package com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl;


import com.letishal.pushdataaftersecuritycontrol.configurations.security.repository.EntityRepository;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.EntityService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class EntityServiceImpl<T,IdType>  implements EntityService<T,IdType> {
    @NonNull
    EntityRepository<T,IdType> repository;
    @Override
    public List<T> findAll() {return repository.findAll();}
    @Override
    public Optional<T> findById(IdType id) {return repository.findById(id);}
    @Override
    public Optional<T> save(T entity) {return Optional.of(repository.save(entity));}
    @Override
    public List<T> pushAll(List<T> entities) {return repository.saveAll(entities);}
    @Override
    public Optional<T> update(T entity) {return Optional.of(repository.save(entity));}
    @Override
    public void remove(IdType id) {repository.deleteById(id);}
}
