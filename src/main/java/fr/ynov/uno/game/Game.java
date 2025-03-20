package fr.ynov.uno.game;

import fr.ynov.uno.game.card.Card;
import fr.ynov.uno.game.card.RegularCard;
import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Card> usedCards;
    private List<Card> leftoverCards;
    private int currentPlayer;
    static int direction;

    public Game() {
    }

    public List<Card> getLeftoverCards() {
        return leftoverCards;
    }

    public void setDirection(int direction) {
        Game.direction = direction;
    }

    private void setupCards(){
        List<Card> cards = new ArrayList<>();
        for(int j = 0; j<2; j++) {
            for (int i = j; i < 10; i++) {
                cards.add(new RegularCard("regular", Color.RED, i));
                cards.add(new RegularCard("regular", Color.BLUE, i));
                cards.add(new RegularCard("regular", Color.GREEN, i));
                cards.add(new RegularCard("regular", Color.YELLOW, i));
            }
        }
        this.leftoverCards = cards;
    }

    public void startGame(){
        setupCards();
    }
}
