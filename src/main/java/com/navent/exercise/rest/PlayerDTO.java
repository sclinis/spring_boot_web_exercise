package com.navent.exercise.rest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Integer goals;
    private Boolean isRetired;
}
