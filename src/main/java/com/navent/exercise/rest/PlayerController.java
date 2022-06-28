package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.services.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    public PlayerServices playerServices;

    @GetMapping
    public List<Player> getPlayersList(){
        return playerServices.getPlayerList();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable (value = "playerId", required = true) Long playerId){
        return playerServices.getPlayerById(playerId);
    }

    @GetMapping("/filteredby")
    public List<Player> getPlayerByName(@RequestParam (value = "name", required = true) String name){
        return playerServices.getPlayersByName(name);
    }

}
