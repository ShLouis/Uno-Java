package fr.ynov.uno.game.card;

import java.awt.*;
import java.util.Objects;

public abstract class PowerCard extends Card {

    PowerCard(String type, Color color, int number) {
        super(type, color, number);
    }

    public abstract boolean usePower();

}
