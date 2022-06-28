package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServices {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.getPlayerList();
    }

    public List<Player> getPLayersByName(String name) {
        List<Player> players = playerRepository.getPlayerList();
        return players.stream().filter(p -> name.equals(p.getName())).collect(Collectors.toList());
    }

    public Player getPlayerById(Long id) {
        List<Player> players = playerRepository.getPlayerList();
        return players.stream().filter(p -> id.equals(p.getId())).findAny().get();
    }

}
