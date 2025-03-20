package fr.ynov.uno.main;

import fr.ynov.uno.game.Game;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        java.util.List<fr.ynov.uno.game.card.Card> cards = new ArrayList<>();
        Game game = new Game();
        game.startGame();
        cards= game.getLeftoverCards();
        for (fr.ynov.uno.game.card.Card card : cards) {
            card.show();
        }
        System.out.println("nb of leftovercards:"+cards.size());
        System.out.println("nb of used cards:"+game.getUsedCards().size());
        System.out.println(game.getPlayers().size());

    }
}
