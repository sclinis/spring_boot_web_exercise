package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServices {
    @Autowired
    private PlayerRepository playerRepository;
    private Player player;


    public List<Player> getPlayerList(){
        return playerRepository.getPlayerList();
    }

    public Player getPlayerById(Long playerId){
        for (Player pyer : playerRepository.getPlayerList()){
            if (playerId.equals(pyer.getId())){
                player = pyer;
                break;
            }
        }
        return player;
    }

    public List<Player> getPlayersByName(String name){
        List<Player> players = new ArrayList<>();
        for (Player pyer : playerRepository.getPlayerList()){
            if (name.equals(pyer.getName())){
                players.add(pyer);
            }
        }
        return players;
    }
}
