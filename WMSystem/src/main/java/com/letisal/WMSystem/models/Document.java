package com.letisal.WMSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Document {
    @Id
    @GeneratedValue
    private Integer Id;
    private Integer id;
    private String inn;
    private LocalDateTime loadingDate;
}
