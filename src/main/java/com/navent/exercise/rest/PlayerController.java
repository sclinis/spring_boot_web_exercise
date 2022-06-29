package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
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
    private playerServices playerServices;
    @Autowired
    private PlayerRepository playerRepository;
   @GetMapping
    public List<Player> getPlayerList(){

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getPlayerList(){
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
       return playerRepository.getPlayerList();
   }
   @GetMapping (value = "/{id}")
   public Player getPlayerById(@PathVariable(value = "id", required = true) Long id){
       return playerServices.getPlayerById(id);
   }
   @GetMapping (value = "/name")
   public List<Player> getPlayersByName(@RequestParam (value = "name") String name) {
       return playerServices.getPlayersByName(name);
   }

    // agregar un jugador
//  @GetMapping
//   public void postPlayer(@RequestBody  Player player){
//       playerRepository.save(player);
//   }
//
}
