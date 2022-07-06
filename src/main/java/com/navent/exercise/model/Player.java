package com.navent.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Integer countGoals;
    private Boolean isRetired;
}
