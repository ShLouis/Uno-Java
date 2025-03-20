package fr.ynov.uno.game.card;

import java.awt.*;
import java.util.Objects;

public class RegularCard extends Card{

    public RegularCard(String type, Color color,int number){
        super(type,color,number);
    }

    public String getType(){
        return type;
    }
    public Color getColor(){
        return color;
    }

    @Override
    public boolean canBePlacedOn(Card bottomCard) {
        return (this.color == null && this.number == null) || (this.color == bottomCard.color) || (Objects.equals(this.number, bottomCard.number));
    }

}
