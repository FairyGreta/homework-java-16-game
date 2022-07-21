package ru.netology.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }

    public List<Player> findAll() {
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = findByName(playerName1);
        Player p2 = findByName(playerName2);

        if (p1 == null || p2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован");
        }

        if (p1.getStrength() == p2.getStrength()) {
            return 0;
        } else if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else if (p1.getStrength() < p2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
