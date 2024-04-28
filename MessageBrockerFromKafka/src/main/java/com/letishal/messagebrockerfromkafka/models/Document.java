package com.letishal.messagebrockerfromkafka.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data

public class Document extends AbstractDto{
    @Id
    @GeneratedValue
    private Integer id;
    private String inn;
    private LocalDateTime loadingDate;
}
