package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPLayers() {
       return playerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Player getPlayerById(  @PathVariable Long id) {
        return playerService.getPLayerById(id);
    }

    @GetMapping(value = "/")
    public List<Player> getPlayersByName(@RequestParam String name){
        return playerService.getPlayersByName(name);
    }
}
