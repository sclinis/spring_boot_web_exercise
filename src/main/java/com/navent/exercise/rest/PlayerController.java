package com.navent.exercise.rest;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("players")
@Validated //habilita que funcione ValidPlayer
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;

    @GetMapping //googlear
    public List<Player> getPlayerList(){
        return playerRepository.getPlayerList();
    } //resuelto el primer controlador

    @GetMapping (value = "/{id}")
    public Player getPlayerById(@PathVariable(value = "id", required = true) Long id){
        return playerService.getNameById(id);
    }
    @GetMapping (value = "/name") //por query string
    public List<Player> getPlayersByName(@RequestParam (value="name") String name){
        return playerService.getListFilteredByName(name);
    }


        //AGREGAR UN JUGADOR
//    @PostMapping("/save") //esto es accesible desde afuera
//    public Player postPlayer(@NotBlank @RequestBody Player player){
//        playerRepository.save(player);
//        return player;
//    }

}
