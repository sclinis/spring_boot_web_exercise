package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.model.PlayerDTO;
import com.navent.exercise.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.getPlayerList();
    }

    public List<Player> getPLayersByName(String name) {
        List<Player> players = playerRepository.getPlayerList();
        return players.stream().filter(p -> name.equals(p.getName())).collect(Collectors.toList());
    }

    public Player getPlayerById(Long id) {
        List<Player> players = playerRepository.getPlayerList();
        return players.stream().filter(p -> id.equals(p.getId())).findAny().get();
    }

    public void savePlayer(Player player){
        playerRepository.savePlayer(player);
    }

    //public void updateGoalsPlayer(Long idPlayer, int goals) {
    //    List<Player> players = playerRepository.getPlayerList();
    //    Player playerFound = players.stream().filter(p -> idPlayer.equals(p.getId())).findAny().get();
    //    playerFound.setTotalGoals(goals);
    //    playerRepository.updatePlayer(playerFound);
    //}

    public Player updateGoals(PlayerDTO playerDTO) {
        List<Player> players = playerRepository.getPlayerList();
        Player playerFound = players.stream().filter(p -> playerDTO.getId().equals(p.getId())).findAny().get();
        playerFound.setTotalGoals(playerDTO.getTotalGoals());
        playerRepository.updatePlayer(playerFound);
        return playerFound;
    }

    public void updateStatus(Player player) {
        playerRepository.updatePlayer(player);
    }

    public Player getPlayerWithMaxGoals() {
        return playerRepository.getPlayerList().stream().max(new PlayerComparator()).get();
    }
}
