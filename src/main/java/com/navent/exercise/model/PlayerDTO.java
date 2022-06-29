package com.navent.exercise.model;

import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private Integer totalGoals;
    private Boolean active;
}
