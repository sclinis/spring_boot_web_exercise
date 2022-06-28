package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/allplayers")
    public List<Player> getPlayerList() {
        return playerService.getPlayersList();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable (value = "playerId") Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/getPlayerBy")
    public List<Player> getPlayersByName(@RequestParam (value = "name") String name) {
        return playerService.getPlayersByNameList(name);
    }

}
