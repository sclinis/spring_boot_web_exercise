package com.navent.exercise.services;

import com.navent.exercise.model.Player;
import com.navent.exercise.repository.PlayerRepository;
import com.navent.exercise.rest.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAll() {
        return playerRepository.getPlayerList();
    }

    public Player getPLayerById(Long id) {
        return playerRepository.getPlayerList().stream().filter(player -> id.equals(player.getId())).collect(Collectors.toList()).get(0);
    }

    public List<Player> getPlayersByName(String name) {
        return playerRepository.getPlayerList().stream().filter(player -> name.equals(player.getName())).collect(Collectors.toList());
    }

    public Player saveNewPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setBirthday(playerDTO.getBirthday());
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        player.setNumberOfGoals((playerDTO.getNumberOfGoals()));
        player.setRetired(playerDTO.isRetired());
        playerRepository.save(player);
        return player;
    }

    public Player editGoals(Long idPlayer, int numberOfGoal) {
        Player playerToEdit = this.getPLayerById(idPlayer);
        playerToEdit.setNumberOfGoals(numberOfGoal);
        return playerToEdit;
    }

    public Player editStatusPlayer(Long idPlayer, boolean newStatus) {
        Player playerToEdit = this.getPLayerById(idPlayer);
        playerToEdit.setRetired(newStatus);
        return playerToEdit;
    }

    public Player getMaxGoalsPlayer() {
        return playerRepository.getPlayerList().stream().max(new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return player1.getNumberOfGoals() - player2.getNumberOfGoals();
            }
        }).get();
    }
}
