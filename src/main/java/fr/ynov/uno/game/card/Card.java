package fr.ynov.uno.game.card;

import java.awt.*;
import java.util.Objects;
/** Card Class
 * This is an abstract class that represents an uno Card, with a color and a number.
 * */
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
    public void setColor(Color color) {
        this.color = color;
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
