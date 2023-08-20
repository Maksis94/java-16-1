package org.example;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        for (String playerName : players.keySet()) {
            if (playerName == name) {
                return players.get(playerName);
            }
        }

        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }

        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
