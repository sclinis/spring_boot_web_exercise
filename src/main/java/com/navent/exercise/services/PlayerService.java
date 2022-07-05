package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.rest.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayerList(){
        return playerRepository.getPlayerList();
    }

    public Player getPlayerById(Long playerId){
        Player playerToReturn = null;
        boolean found = false;
        for (Player playerTemp : getPlayerList()){
            if (playerId.equals(playerTemp.getId())){
                playerToReturn = playerTemp;
                found = true;
                break;
            }
        }
        if (!found){
            return new Player();
        }
        return playerToReturn;
    }

    public List<Player> getFilteredPlayerList(String name){
        List<Player> filteredPlayerList = new ArrayList<>();
        for (Player playerTemp : getPlayerList()){
            if (name.equalsIgnoreCase(playerTemp.getName())){
                filteredPlayerList.add(playerTemp);
            }
        }
        return filteredPlayerList;
    }


    public void updateGoalsByName(String name, Integer goals){
        for (Player playerTemp : getPlayerList()){
            if (name.equalsIgnoreCase(playerTemp.getName())){
                playerTemp.setGoals(goals);
                break;
            }
        }
    }
}
