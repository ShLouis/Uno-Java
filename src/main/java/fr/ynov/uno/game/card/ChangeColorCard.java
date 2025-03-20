package fr.ynov.uno.game.card;

import java.awt.*;

public class ChangeColorCard extends PowerCard{

    public ChangeColorCard(String type, Color color, Integer number) {
        super(type, color, number);
    }

    @Override
    public void usePower() {
        this.color=Color.RED;
    }
}
