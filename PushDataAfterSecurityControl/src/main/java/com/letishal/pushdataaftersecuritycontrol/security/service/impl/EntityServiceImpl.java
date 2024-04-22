package com.letishal.pushdataaftersecuritycontrol.security.service.impl;
import com.letishal.pushdataaftersecuritycontrol.security.repository.EntityRepository;
import com.letishal.pushdataaftersecuritycontrol.security.service.EntityService;
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
    public Optional<T> findById(IdType id) {return repository.findById(id);}

    @Override
    public List<T> findAll() {return repository.findAll();}

    @Override
    public Optional<T> save(T entity) {return Optional.of(repository.save(entity));}

}
