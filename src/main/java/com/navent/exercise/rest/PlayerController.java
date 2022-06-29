package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.model.PlayerDTO;
import com.navent.exercise.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")  // players/**id**
    public Player getPlayersByName(@PathVariable(value = "id") Long id){
        return playerService.getPlayerById(id);
    }

    @GetMapping("/player")  // players/player?name=**name**
    public List<Player> getPlayerById(@RequestParam String name) {
        return playerService.getPLayersByName(name);
    }

    // Agregar un jugador

    @PostMapping("/save")
    public void savePlayer(@RequestBody Player player){
        playerService.savePlayer(player);
    }

    //@GetMapping("/updateGoals") // localhost:8080/players/updateGoals?id=5&goals=1000
    //public void updateGoalsPlayer(@RequestParam Long id, @RequestParam int goals) {
    //    playerService.updateGoalsPlayer(id,goals);
    //}

    @PatchMapping("/update")
    public Player updateGoals(@RequestBody PlayerDTO playerDTO) {
        return playerService.updateGoals(playerDTO);
    }

    @PutMapping("/updateStatus")
    public Player updateStatus(@RequestBody Player player) {
        playerService.updateStatus(player);
        return player;
    }

    @GetMapping("/maxGoals")
    public Player getPlayerWithMaxGoals() {
        return playerService.getPlayerWithMaxGoals();
    }
}
