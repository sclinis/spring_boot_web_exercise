package com.navent.exercise.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private LocalDate birthday;
}
