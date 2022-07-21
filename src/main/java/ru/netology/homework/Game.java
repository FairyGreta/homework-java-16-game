package ru.netology.homework;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    //protected final ArrayList<Player> players = new ArrayList<>();
    HashMap<Integer, Player> players = new HashMap<>();

    public void register(Player player) {
        //players.add(player);
        players.put(player.getId(), player);
    }

    public Player findByName(String name) {
        for (Player player : players.values()) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = findByName(playerName1);
        Player p2 = findByName(playerName2);

//        for (Player player : players) {
//            if (player.getName().equals(playerName1)) {
//                p1 = player;
//            }
//            if (player.getName().equals(playerName2)) {
//                p2 = player;
//            }
//        }
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
