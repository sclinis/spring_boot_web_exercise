package com.navent.exercise.services;

import com.navent.exercise.model.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getTotalGoals() - o2.getTotalGoals();
    }
}
