package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;

public class ReverseCard extends PowerCard{
    public ReverseCard(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a reverse card");
        game.setDirection(-game.getDirection());
    }
}
