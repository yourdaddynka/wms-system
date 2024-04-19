package com.letisal.WMSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Data
@Entity
public class StockGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sector;
    private Integer rack;
}
