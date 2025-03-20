package fr.ynov.uno.game.card;

import java.awt.*;

public abstract class Card {
    protected Color color;
    protected Integer number;
    protected String type;

    Card(String type, Color color, int number) {
        this.type = type;
        this.color = color;
        this.number = number;
    }

    public abstract boolean canBePlacedOn(Card bottomCard);
}
