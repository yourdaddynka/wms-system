package com.letisal.WMSystem.service.implement;
import com.letisal.WMSystem.models.Document;
import com.letisal.WMSystem.repository.DocumentRepository;
import com.letisal.WMSystem.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Primary
public class DocumentServiceImpl implements EntityService<Document> {
    private final DocumentRepository repository;
    @Override
    public List<Document> findAll() {return repository.findAll();}
    @Override
    public List<Document> pushAll(List<Document> entities) {return repository.saveAll(entities);}
    @Override
    public Optional<Document> save(Document entity) {return Optional.of(repository.save(entity));}
    @Override
    public Optional<Document> findById(Long id) {return repository.findById(id);}
    @Override
    public Optional<Document> update(Document entity) {return Optional.of(repository.save(entity));}
    @Override
    public void remove(Long id) {repository.deleteById(id);}
}
