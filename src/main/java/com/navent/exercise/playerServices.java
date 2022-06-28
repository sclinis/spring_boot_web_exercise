package com.navent.exercise;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class playerServices {
    @Autowired
    private PlayerRepository playerRepository;


    public Player getPlayerById(Long id) {
       Player player = new Player();
        for (Player p : playerRepository.getPlayerList()) {
            if (p.getId().equals(id)) {
                player = p;
                break;
            }
        }
        return player;
    }
    public List<Player> getPlayersByName(String name) {
        List<Player> playersByName = new ArrayList<>();
        for (Player player : playerRepository.getPlayerList()) {
            if (name.equals(player.getName())) {
                playersByName.add(player);
            }
        }
        return playersByName;
    }

}


