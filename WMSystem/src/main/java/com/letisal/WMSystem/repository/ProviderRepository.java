package com.letisal.WMSystem.repository;

import com.letisal.WMSystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Product,Long> {
}
