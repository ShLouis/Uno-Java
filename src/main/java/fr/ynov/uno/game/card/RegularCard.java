package fr.ynov.uno.game.card;

import java.awt.*;
import java.util.Objects;
/** RegularCard Class
 * This card represents a regular uno card with a number and color
 * */
public class RegularCard extends Card {

    public RegularCard(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }
}
