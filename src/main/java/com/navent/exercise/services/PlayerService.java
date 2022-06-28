package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayersList() {
        return playerRepository.getPlayerList();
    }

    public Player getPlayerById(Long playerId) {
        Player playerById = null;
        for (Player player : playerRepository.getPlayerList()) {
            if (playerId.equals(player.getId())) {
                playerById = player;
                break;
            }
        }
        return playerById;
    }

    public List<Player> getPlayersByNameList(String name) {
        List<Player> playersByNameList = new ArrayList<>();
        for (Player player : playerRepository.getPlayerList()) {
            if (name.equals(player.getName())) {
                playersByNameList.add(player);
            }
        }
        return playersByNameList;
    }
}
