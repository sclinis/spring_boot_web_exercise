package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping
    public List<Player> listPlayers() {
        return playerRepository.getPlayerList();
    }

}
