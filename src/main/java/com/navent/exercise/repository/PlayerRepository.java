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



    }

//    // para agregar un jugador
//    public void save(Player player){
//        playerList.add(player);
//    }

