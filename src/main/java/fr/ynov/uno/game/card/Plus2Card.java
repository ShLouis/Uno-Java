package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;

public class Plus2Card extends PowerCard{
    public Plus2Card(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a plus 2 card");
        int next=1;
        if (game.getCurrentPlayer()==game.getPlayers().size()-1){
            next=-game.getPlayers().size()-1;
        }
        for (int i=0;i<2;i++) {
            game.getPlayers().get(game.getCurrentPlayer()+next).getPlayerCards().add(game.takeCard());
        }

    }


}
