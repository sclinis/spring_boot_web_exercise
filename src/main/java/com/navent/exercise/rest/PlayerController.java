package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.navent.exercise.repository.PlayerRepository;
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
    public Player getPlayerById(  @PathVariable Long id) {
        return playerService.getPLayerById(id);
    }

    @GetMapping(value = "/")
    public List<Player> getPlayersByName(@RequestParam String name){
        return playerService.getPlayersByName(name);
    }
    @Autowired
    private PlayerRepository playerRepository;

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





}
