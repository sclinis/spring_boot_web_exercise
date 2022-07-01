package com.navent.exercise.clients;

import com.navent.exercise.clients.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonClient {

    @Value("${configuration.pokemons.url}")
    private String url;


    @Autowired // http://www.baeldung.com/rest-template
    private RestTemplate restTemplate;


    public Pokemon getPikachu() {
        return restTemplate.getForObject(url, Pokemon.class);
    }

}
