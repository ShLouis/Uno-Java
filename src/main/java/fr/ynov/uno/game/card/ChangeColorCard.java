package fr.ynov.uno.game.card;

import java.awt.*;

public class ChangeColorCard extends PowerCard{

    ChangeColorCard(String type, Color color, int number) {
        super(type, color, number);
    }

    @Override
    public void usePower() {
        this.color=Color.RED;
    }
}
