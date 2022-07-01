package com.navent.exercise.clients;

import com.navent.exercise.clients.model.Pokemon;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PokemonFeignClient", url = "${configuration.pokemons-feign.api}")
@Headers("Content-Type: application/json")
public interface PokemonFeignClient {

    @GetMapping(value = "pokemon/{name}")
    Pokemon getPokemon(@PathVariable("name") String pokemonName);
}
