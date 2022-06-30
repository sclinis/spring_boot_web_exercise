package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.services.PlayerService;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.navent.exercise.validator.ValidPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@RestController
@RequestMapping("players")
@Validated
@Slf4j
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPLayers() {
        return playerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPLayerById(id);
    }

    @GetMapping(value = "/")
    public List<Player> getPlayersByName(@RequestParam String name) {
        return playerService.getPlayersByName(name);
    }

    @PostMapping("/save")
    public Player postPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.saveNewPlayer(playerDTO);
    }

    @PatchMapping(value = "/edit-player-goals/{id}/")
    public Player editPlayerGoals(@PathVariable Long id, @RequestParam int numberGoals) {
        return playerService.editGoals(id, numberGoals);
    }

    @PutMapping(value = "/edit-player-status/{id}/")
    public Player editPlayerStatus(@PathVariable Long id, @RequestParam boolean isRetired) {
        return playerService.editStatusPlayer(id, isRetired);
    }

    @GetMapping(value = "/get-max-goals-player")
    public Player getMaxPlayerGoals() {
        return playerService.getMaxGoalsPlayer();
    }
}
