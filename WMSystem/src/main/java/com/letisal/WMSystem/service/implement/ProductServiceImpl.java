package com.letisal.WMSystem.service.implement;
import com.letisal.WMSystem.models.Product;
import com.letisal.WMSystem.repository.ProductRepository;
import com.letisal.WMSystem.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Primary
public class ProductServiceImpl implements EntityService<Product> {
    private final ProductRepository repository;
    @Override
    public List<Product> findAll() {return repository.findAll();}
    @Override
    public List<Product> pushAll(List<Product> entities) {return repository.saveAll(entities);}
    @Override
    public Optional<Product> save(Product entity) {return Optional.of(repository.save(entity));}
    @Override
    public Optional<Product> findById(Long id) {return repository.findById(id);}
    @Override
    public Optional<Product> update(Product entity) {return Optional.of(repository.save(entity));}
    @Override
    public void remove(Long id) {repository.deleteById(id);}
}
