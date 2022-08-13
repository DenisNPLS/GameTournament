package ru.netology.game;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.repository.RepositoryOfPlayers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {

    private Collection<Player> players;
    RepositoryOfPlayers repository;

    public void register(Player player) {
        repository.add(player);
    }

    public Game(RepositoryOfPlayers repository) {
        this.repository = repository;
    }

    public Player[] getAll() {
        return repository.findAll().toArray(new Player[0]);
    }

    public Player findByName(String name) {
        Player[] players = repository.findAll().toArray(new Player[0]);
        Player newMember = null;
        for (Player player : players) {
            if (player.getName() == name) {
                newMember = new Player(player.getId(), player.getName(), player.getStrength());
            }
        }
        return newMember;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player with name " + playerName1 + " is not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player with name " + playerName2 + " is not registered");
        }
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        int result = player1.compareTo(player2);
        return result;
    }

}
