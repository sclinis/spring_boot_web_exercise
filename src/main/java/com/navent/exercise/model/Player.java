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
    private Integer numbersOfGoals;
    private Boolean play;

//    public Player() {
//    }
//
//    public Player(Long id, String name, String surname, LocalDate birthday, Integer numbersOfGoals, Boolean play) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.birthday = birthday;
//        this.numbersOfGoals = numbersOfGoals;
//        this.play = play;
//    }
}
