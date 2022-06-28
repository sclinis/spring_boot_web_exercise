package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.playerServices;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    private playerServices playerServices;
    @Autowired
    private PlayerRepository playerRepository;
   @GetMapping
    public List<Player> getPlayerList(){

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
