//package com.letishal.pushdataaftersecuritycontrol.configurations.security.experemental;
//
//import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.User;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("test")
//@FieldDefaults(level = AccessLevel.PUBLIC,makeFinal = true)
//public class ExperementalController implements ExperementalService<User,Long>{
//    @NonNull
//    ExperementalService<User,Long> service;
//
//    @Override
//    @RequestMapping()
//    public List<User> findAll() {return service.findAll();}
//    @Override
//    @RequestMapping("/get/{id}")
//    public Optional<User> findById(@PathVariable Long id) {return service.findById(id);}
//    @Override
//    @RequestMapping("/{entity}")
//    public Optional<User> save(@PathVariable User entity) {return service.save(entity);}
//    @Override
//    @RequestMapping("/set/{entities}")
//    public List<User> pushAll(@PathVariable List<User> entities) {return service.pushAll(entities);}
//    @Override
//    @RequestMapping("/set/{entity}")
//    public Optional<User> update(@PathVariable User entity) {return service.update(entity);}
//    @Override
//    @RequestMapping("/delete/{id}")
//    public void remove(@PathVariable Long id) {service.remove(id);}
//}
