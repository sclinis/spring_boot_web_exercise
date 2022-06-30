package com.navent.exercise.repository;

import com.navent.exercise.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Repository ya viene con varios meth incluidos
public class PlayerRepository {
    @Autowired
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    //method que me permita agregar new player
//    public void save(Player player){
//        player.setId(this.getLastId() +1);
//        playerList.add(player);
//    }
}
