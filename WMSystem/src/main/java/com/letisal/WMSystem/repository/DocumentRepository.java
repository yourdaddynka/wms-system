package com.letisal.WMSystem.repository;

import com.letisal.WMSystem.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
