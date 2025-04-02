package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;
import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.ArrayList;
/** ReverseCard Class
 * This class represents the uno card that switches the game direction
 * */
public class ReverseCard extends PowerCard{
    public ReverseCard(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a reverse card");
        int newRight=game.getLeft();
        game.setLeft(game.getRight());
        game.setRight(newRight);
        if(game.getCurrentPlayer()==1){
            game.setCurrentPlayer(3);
        } else if(game.getCurrentPlayer()==3){
            game.setCurrentPlayer(1);
        }
        ArrayList<Player> newPlayerList = new ArrayList<>();
        if (game.getLeft()==1){
            newPlayerList.add(game.getPlayers().getFirst());
            newPlayerList.add(game.getPlayers().get(game.getRight()));
            newPlayerList.add(game.getPlayers().get(2));
            newPlayerList.add(game.getPlayers().get(game.getLeft()));
        }else{
            newPlayerList.add(game.getPlayers().getFirst());
            newPlayerList.add(game.getPlayers().get(game.getLeft()));
            newPlayerList.add(game.getPlayers().get(2));
            newPlayerList.add(game.getPlayers().get(game.getRight()));
        }
        game.setPlayers(newPlayerList);
        game.getGui().addOtherPlayerCards(game);
        game.getGui().addCentreCards(game);
        if (game.getCurrentPlayer()!=0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
