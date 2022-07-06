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

    public Player getPlayerWithMostGoals(){
        Player playerToReturn = playerList.get(2);
        for(Player playerTemp : playerList){
            if (playerToReturn.getGoals() < playerTemp.getGoals()){
                playerToReturn = playerTemp;
            }
        }
        return playerToReturn;
    }

    public void save(Player player){
        player.setId(this.getLastId() +1 );
        playerList.add(player);
    }

    private Long getLastId(){
        return playerList.stream().map(Player::getId).max(Long::compare).orElse(0L);
    }
}
