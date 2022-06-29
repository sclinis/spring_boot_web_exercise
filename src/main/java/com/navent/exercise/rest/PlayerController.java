package com.navent.exercise.rest;

import com.navent.exercise.configuration.ExampleConfiguration;
import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.rest.dto.PlayerDTO;
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
    private PlayerRepository playerRepository;

    @Autowired
    private ExampleConfiguration config;

    @GetMapping
    public List<Player> getPlayerList(){
        log.info(config.getExample());
        return playerRepository.getPlayerList();
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
}
