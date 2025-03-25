package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;
import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.Scanner;

public class ChangeColorCard extends PowerCard{

    public ChangeColorCard(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a change color card");
        if (game.getCurrentPlayer()==0) {
            game.getGui().chooseColor(game);
            while (this.color==null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            for(Card c:game.getPlayers().get(game.getCurrentPlayer()).getPlayerCards()){
                if(c.getColor() != null){
                    this.color = c.getColor();
                }
            }
            System.out.println("the color has changed to " + this.color);
        }
    }
}
