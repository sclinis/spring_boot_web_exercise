package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.rest.dto.PlayerDTO;
import com.navent.exercise.services.PlayerService;
import com.navent.exercise.validator.ValidPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
@Validated
@Slf4j
public class PlayerController {

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getPlayerList(){
        return playerService.getPlayerList();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable (value = "playerId" , required = true) Long playerId){
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("playersByName")
    public List<Player> getFilteredPlayerList(@RequestParam (value = "name" , required = true) String name){
        return playerService.getFilteredPlayerList(name);
    }

    @PostMapping("/savePlayer")
    public void postPlayer(@RequestBody Player player){
        playerRepository.save(player);
    }


    //AGREGAR UN JUGADOR
    @PostMapping("/save")
    public Player postPlayer( @ValidPlayer @RequestBody PlayerDTO playerDTO){
        log.trace("Entra en controller");
        Player player = new Player();
        player.setBirthday(playerDTO.getBirthday());
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        log.info("Modifico player");
        playerRepository.save(player);
        log.debug("Sale del controller");
        return player;
    }

    @PatchMapping("/updateGoalsByPlayerName")
    public void updateGoalsByPlayerName (@RequestBody String name, Integer goals){
        playerService.updateGoalsByName(name, goals);
    }
}
