package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;
import java.util.Objects;
/** PowerCard Class
 * This abstract class represents the cards that do something extra
 * */
public abstract class PowerCard extends Card {

    PowerCard(String name, String type, Color color, Integer number) {
        super(name, type, color, number);
    }

    public abstract void usePower(Game game);
}
