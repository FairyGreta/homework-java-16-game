package ru.netology.homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Anna", 5);
    Player player2 = new Player(2, "Boris", 5);
    Player player3 = new Player(3, "Petya", 7);
    Player player4 = new Player(4, "Vasya", 11);
    Player player5 = new Player(5, "Tom", 10);

    @Test
    public void shouldCompareStrengthOfTwoPlayersDraw() {
        Game registeredPlayer = new Game();

        registeredPlayer.register(player1);
        registeredPlayer.register(player2);

        int expected = 0;
        int actual = registeredPlayer.round(player1.getName(), player2.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersFirstStronger () {
        Game registeredPlayer = new Game();

        registeredPlayer.register(player4);
        registeredPlayer.register(player5);

        int expected = 1;
        int actual = registeredPlayer.round(player4.getName(), player5.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersSecondStronger () {
        Game registeredPlayer = new Game();

        registeredPlayer.register(player3);
        registeredPlayer.register(player4);

        int expected = 2;
        int actual = registeredPlayer.round(player3.getName(), player4.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckNotRegisteredExceptionForFirstPlayer() {
        Game registeredPlayer = new Game();

        registeredPlayer.register(player2);

        assertThrows(NotRegisteredException.class, ()-> {
            registeredPlayer.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void shouldCheckNotRegisteredExceptionForSecondPlayer() {
        Game registeredPlayer = new Game();

        registeredPlayer.register(player1);

        assertThrows(NotRegisteredException.class, ()-> {
            registeredPlayer.round(player1.getName(), player2.getName());
        });
    }

}
