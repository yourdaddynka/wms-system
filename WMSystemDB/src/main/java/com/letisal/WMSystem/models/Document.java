package com.letisal.WMSystem.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@JsonSerialize
public class Document {
    @Id
    @GeneratedValue
    private Integer id;
    private String inn;
    private LocalDateTime loadingDate;
}
