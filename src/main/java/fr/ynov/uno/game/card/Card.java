package fr.ynov.uno.game.card;

import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.Objects;

public abstract class Card {
    protected Color color;
    protected Integer number;
    protected String type;

    Card(String type, Color color, Integer number) {
        this.type = type;
        this.color = color;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }
    public Integer getNumber() {
        return number;
    }
    public String getType() {
        return type;
    }

    public boolean canBePlacedOn(Card bottomCard) {
        return (this.color == null && this.number == null) || (this.color == bottomCard.color) || (Objects.equals(this.number, bottomCard.number));
    }

    public void show(){
        System.out.println(type);
    }
}
