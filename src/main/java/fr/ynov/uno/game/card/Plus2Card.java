package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;
/** Plus2Card Class
 * This class represents the uno card that makes the next player pickup 2 cards
 * */
public class Plus2Card extends PowerCard{
    public Plus2Card(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a plus 2 card");
        int next;
        if (game.getCurrentPlayer()>=game.getPlayers().size()-1){
            next=0;
        }else{
            next=game.getCurrentPlayer()+1;
        }
        for (int i=0;i<2;i++) {
            game.getPlayers().get(next).getPlayerCards().add(game.takeCard());
        }

    }

}
