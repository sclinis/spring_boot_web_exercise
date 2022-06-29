package com.navent.exercise.rest;

import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    private PlayerRepository repository;

    @PostMapping
    public void test() {

    }
}
