package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        return (int) (player1.getGoals() - player2.getGoals());
    }

}
