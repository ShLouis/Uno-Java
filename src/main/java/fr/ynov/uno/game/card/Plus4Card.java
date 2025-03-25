package fr.ynov.uno.game.card;

import fr.ynov.uno.game.Game;

import java.awt.*;
import java.util.Scanner;

public class Plus4Card extends PowerCard{

    public Plus4Card(String name,String type, Color color, Integer number) {
        super(name,type, color, number);
    }

    @Override
    public void usePower(Game game) {
        System.out.println("player" +game.getCurrentPlayer()+"used a plus 4 card");
        int next=1;
        if (game.getCurrentPlayer()==game.getPlayers().size()-1){
            next=0;
        }
        for (int i=0;i<4;i++) {
            game.getPlayers().get(game.getCurrentPlayer()+next).getPlayerCards().add(game.takeCard());
        }
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
