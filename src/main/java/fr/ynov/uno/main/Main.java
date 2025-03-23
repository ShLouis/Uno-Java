package fr.ynov.uno.main;

import fr.ynov.uno.game.Game;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        java.util.List<fr.ynov.uno.game.card.Card> cards = new ArrayList<>();
        Game game = new Game();
        game.startGame();
    }
}
