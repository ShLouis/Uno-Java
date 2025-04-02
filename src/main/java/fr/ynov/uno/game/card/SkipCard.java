package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;
/** SkipCard Class
 * This class represents the uno card that skips the next player's turn
 * */
public class SkipCard extends PowerCard{
    public SkipCard(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a skip card");

        if (game.getCurrentPlayer()==game.getPlayers().size()-2){
            game.setCurrentPlayer(0);
        }
        else if (game.getCurrentPlayer()>=game.getPlayers().size()-1){
            game.setCurrentPlayer(1);
        }else {
            game.setCurrentPlayer(game.getCurrentPlayer() + 1);
        }


    }
}
