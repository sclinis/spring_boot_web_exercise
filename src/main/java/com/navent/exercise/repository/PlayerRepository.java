package com.navent.exercise.repository;

import com.navent.exercise.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {
    @Autowired
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void savePlayer(Player player){
        playerList.add(player);
    }

    public void updatePlayer(Player player) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getId() == player.getId()){
                playerList.set(i, player);
                break;
            }
        }
    }
}
