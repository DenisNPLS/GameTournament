package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.game.Game;
import ru.netology.repository.RepositoryOfPlayers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Player player1 = new Player(1, "Denis", 5);
    private Player player2 = new Player(2, "Sasha", 8);
    private Player player3 = new Player(3, "Artem", 3);
    private Player player4 = new Player(4, "Oleg", 2);
    private Player player5 = new Player(5, "Alex", 5);


    @Test
    void RoundWinnerPlayer1() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Denis", "Artem");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void RoundWinnerPlayer2() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Denis", "Sasha");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void DrownGame() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Denis", "Alex");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void ShouldFindNotRegisteredPlayer() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.findByName("Kostya");

        Player[] actual = game.getAll();
        Player[] expected = {player1, player2, player3, player4, player5};

        assertArrayEquals(actual, expected);

    }

    @Test
    void Player1IsNotRegistered() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Kostya", "Denis");
        });
    }

    @Test
    void Player2IsNotRegistered() {
        Game game = new Game(new RepositoryOfPlayers());
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Denis", "Philip");
        });
    }
}
