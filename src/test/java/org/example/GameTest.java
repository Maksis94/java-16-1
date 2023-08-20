package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Игрок 1", 100);
    Player player2 = new Player(2, "Игрок 2", 120);
    Player player3 = new Player(3, "Игрок 3", 90);
    Player player4 = new Player(4, "Игрок 4", 140);
    Player player5 = new Player(5, "Игрок 5", 100);

    @Test
    public void shouldFailOnUnregisteredPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 6", "Игрок 2");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 3", "Игрок 6");
        });
    }

    @Test
    public void shouldCompleteRounds() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertEquals(game.round("Игрок 1", "Игрок 2"), 2);
        Assertions.assertEquals(game.round("Игрок 2", "Игрок 3"), 1);
        Assertions.assertEquals(game.round("Игрок 2", "Игрок 4"), 2);
        Assertions.assertEquals(game.round("Игрок 4", "Игрок 5"), 1);
        Assertions.assertEquals(game.round("Игрок 1", "Игрок 5"), 0);
    }
}
