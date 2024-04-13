package com.letisal.WMSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StockGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sector;
    private Integer rack;
}
