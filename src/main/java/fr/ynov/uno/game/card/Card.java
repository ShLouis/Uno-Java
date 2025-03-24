package fr.ynov.uno.game.card;

import java.awt.*;
import java.util.Objects;

public abstract class Card {
    protected Color color;
    protected Integer number;
    protected String type;
    protected String name;

    Card(String name,String type, Color color, Integer number) {
        this.name = name;
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
    public String getName() {
        return name;
    }
    public String getType(){return type;}

    public boolean canBePlacedOn(Card bottomCard) {
        return (this.color == null && this.number == null) || (this.color == bottomCard.color) || (Objects.equals(this.number, bottomCard.number)) || (bottomCard.color==null && bottomCard.number == null);
    }

    public void show(){
        System.out.println(name);
    }
}
