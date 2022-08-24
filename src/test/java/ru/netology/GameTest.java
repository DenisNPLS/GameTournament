package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.game.Game;

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
    void shouldWonPlayer1() {
        Game game = new Game();
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
    void shouldWonPlayer2() {
        Game game = new Game();
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
    void playersShouldPlayDrownGame() {
        Game game = new Game();
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
    void shouldFindNotRegisteredPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Kostya", "Georgiy");
        });

    }

    @Test
    void shouldFindFirstNotRegisteredPlayer() {
        Game game = new Game();
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
    void shouldFindSecondNotRegisteredPlayer() {
        Game game = new Game();
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
