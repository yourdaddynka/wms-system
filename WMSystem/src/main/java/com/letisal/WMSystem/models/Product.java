package com.letisal.WMSystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productDescription;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Boolean saleStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private StockGeo stockGeo;
}