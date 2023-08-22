package org.example;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
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
