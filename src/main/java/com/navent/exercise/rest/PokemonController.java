package com.navent.exercise.rest;

import com.navent.exercise.clients.model.Pokemon;
import com.navent.exercise.clients.PokemonClient;
import com.navent.exercise.clients.PokemonFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemons")
public class PokemonController {

    @Autowired
    private PokemonClient client;

    @Autowired
    private PokemonFeignClient feignClient;

    @GetMapping("pikachu")
    public Pokemon getPikachu() {
        return client.getPikachu();
    }

    @GetMapping("feign/pikachu")
    public Pokemon getPikachuFeign() {
        return feignClient.getPokemon("pikachu");
    }

}
