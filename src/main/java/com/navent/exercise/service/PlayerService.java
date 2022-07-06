package com.navent.exercise.service;

import com.navent.exercise.configuration.ExampleConfiguration;
import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private ExampleConfiguration exampleConfiguration;
    @Autowired
    private PlayerRepository playerRepository;

    //List<Player> playerList = exampleConfiguration.initPlayerList();


//    public Player getNameById(Long id){
//        Player find = new Player(); //Se puede declarar también como private Player player;
//        for(Player pl: playerRepository.getPlayerList()){
//            if(pl.getId().equals(id)){
//                find = pl;
//                break;
//            }
//            else{
//                find = null;
//            }
//        }
//        return find;
//    }

    public Player getNameById(Long id){
        List<Player> result = exampleConfiguration.initPlayerList().stream()
                .filter(item -> item.equals(id))
                .collect(Collectors.toList());
                if(!result.isEmpty()){
                    return (Player)result;
                }
                else {
                    return null;
                }

    }

    @GetMapping
    public List<Player> getListFilteredByName(String name){
        List<Player> filteredList = new ArrayList<>();
        for(Player lp: playerRepository.getPlayerList()){
            if(lp.getName().equals(name)){
                filteredList.add(lp);
            }
        }
        return filteredList;
    }

}
