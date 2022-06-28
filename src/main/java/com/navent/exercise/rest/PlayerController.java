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
    PlayerServices playerServices;

    @GetMapping("/")
    public List<Player> getPlayers(){
        return playerServices.getPlayers();
    }

    @GetMapping("/{name}")  // players/**playerName**
    public List<Player> getPlayersByName(@PathVariable(value = "name") String name){
        return playerServices.getPLayersByName(name);
    }

    @GetMapping("/player")  // players/player?id=**numberId**
    public Player getPlayerById(@RequestParam Long id) {
        return playerServices.getPlayerById(id);
    }
}
