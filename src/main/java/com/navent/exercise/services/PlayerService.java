package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAll() {
        return playerRepository.getPlayerList();
    }

    public Player getPLayerById(Long id) {
        return playerRepository.getPlayerList().stream().filter(player -> id.equals(player.getId())).collect(Collectors.toList()).get(0);
    }

    public List<Player> getPlayersByName(String name) {
        return playerRepository.getPlayerList().stream().filter(player -> name.equals(player.getName())).collect(Collectors.toList());
    }
}
