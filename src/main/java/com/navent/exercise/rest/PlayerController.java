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

    @GetMapping("/allPlayers")
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

    @PostMapping("/savePlayer")
    public Player postPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.savePlayer(playerDTO);
    }

    @PatchMapping("/updatePlayerGoals/{playerId}")
    public Player updatePlayerGoals(@PathVariable (value = "playerId") Long playerId, @RequestParam (value = "goals") Integer goals) {
       return playerService.updatePlayerGoals(playerId, goals);
    }

    @PutMapping("/updatePlayerCondition/{playerId}")
    public Player updatePlayerCondition(@PathVariable (value = "playerId") Long playerId, @RequestParam (value = "isRetired") Boolean retired) {
        return playerService.updatePlayerCondition(playerId, retired);
    }

    @GetMapping("/getMaxGoalsPlayer")
    public Player getMaxGoalsPlayer() {
        return playerService.getMaxGoalsPlayer();
    }

}
