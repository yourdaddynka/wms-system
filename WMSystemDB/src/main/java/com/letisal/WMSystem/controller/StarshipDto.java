package com.letisal.WMSystem.controller;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StarshipDto extends AbstractDocument {

    private String name;
    private String model;

}