package com.letisal.WMSystem.repository;

import com.letisal.WMSystem.models.StockGeo;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockGeoRepository extends JpaRepository<StockGeo, Long> {
}
