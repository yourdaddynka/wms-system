//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import lombok.AccessLevel;
//
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PUBLIC)
//public class ExperementalServiceImpl<T, ID> implements ExperementalService<T, ID> {
//    @NonNull
//    ExperementalRepository<T, ID> repository;
//    @Override
//    public List<T> findAll() {return repository.findAll();}
//    @Override
//    public Optional<T> findById(ID id) {return repository.findById(id);}
//    @Override
//    public Optional<T> save(T entity) {return Optional.of(repository.save(entity));}
//    @Override
//    public List<T> pushAll(List<T> entities) {return repository.saveAll(entities);}
//    @Override
//    public Optional<T> update(T entity) {return Optional.of(repository.save(entity));}
//    @Override
//    public void remove(ID id) {repository.deleteById(id);}
//}
