package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Player player1 = new Player(1, "Kolya", 3);
    Player player2 = new Player(2, "Anna", 7);
    Player player3 = new Player(3, "Sveta", 10);
    Player player4 = new Player(4, "Boris", 7);
    Player player5 = new Player(5, "Ivan", 2);


    @Test
    void shouldFindWinner1() {

        Game players = new Game();

        players.register(player3);
        players.register(player4);

        int expected = 1;
        int actual = players.round(player3.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldFindWinner2() {

        Game players = new Game();

        players.register(player1);
        players.register(player2);

        int expected = 2;
        int actual = players.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldFindIfTie() {

        Game players = new Game();

        players.register(player2);
        players.register(player4);

        int expected = 0;
        int actual = players.round(player2.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowNotRegistered1() {
        Game players = new Game();

        players.register(player1);

        assertThrows(NotRegisteredException.class, () -> {
            players.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void shouldThrowNotRegistered2() {
        Game players = new Game();

        players.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            players.round(player1.getName(), player2.getName());
        });
    }


}
