package com.navent.exercise.services;

import com.navent.exercise.model.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        return player1.getNumbersOfGoals()-player2.getNumbersOfGoals();
    }
}
