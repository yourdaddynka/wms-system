//package com.letishal.pushdataaftersecuritycontrol.configurations.security.controller;
//
//import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.EntityService;
//
//import com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl.EntityServiceImpl;
//import lombok.AccessLevel;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Controller
//@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
//@RequiredArgsConstructor
//public class TestEntityController<T,IdType> implements EntityService<T,IdType> {
//    @NonNull
//    EntityServiceImpl<T,IdType> service;
//    @GetMapping("get/{id}")
//    @ResponseBody
//    @Override
//    public Optional<T> findById(@PathVariable IdType id) {return service.findById(id);}
//
//    @GetMapping("get/")
//    @ResponseBody
//    @Override
//    public List<T> findAll() { return service.findAll();}
//
//    @PostMapping("set/")
//    @ResponseBody
//    @Override
//    public List<T> pushAll(List<T> entities) {return service.pushAll(entities);}
//
//    @PostMapping("set/{role}")
//    @ResponseBody
//    @Override
//    public Optional<T> save(@PathVariable T role) {return service.save(role);}
//    @PostMapping("update/{role}")
//    @ResponseBody
//    @Override
//    public Optional<T> update(@PathVariable T role) {return service.update(role);}
//    @DeleteMapping("delete/{id}")
//    @ResponseBody
//    @Override
//    public void remove(@PathVariable IdType id) {service.remove(id);}
//}
