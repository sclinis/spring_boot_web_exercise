package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.rest.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerComparator playerComparator;

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

    public Player savePlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setBirthday(playerDTO.getBirthday());
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        player.setGoals((playerDTO.getGoals()));
        player.setIsRetired(playerDTO.getIsRetired());
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayerGoals(Long playerId, Integer goals) {
        Player player = this.getPlayerById(playerId);
        player.setGoals(goals);
        return player;
    }

    public Player updatePlayerCondition (Long playerId, Boolean retired) {
        Player player = this.getPlayerById(playerId);
        player.setIsRetired(retired);
        return player;
    }

    public Player getMaxGoalsPlayer() {
        return Collections.max(this.getPlayersList(), playerComparator);
    }
}
