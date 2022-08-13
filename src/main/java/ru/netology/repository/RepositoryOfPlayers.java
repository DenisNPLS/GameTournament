package ru.netology.repository;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class RepositoryOfPlayers {
    private Collection<Player> players;

    public RepositoryOfPlayers() {
        this.players = new ArrayList<>();
    }

    public void add(Player player) {
        players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }
}
