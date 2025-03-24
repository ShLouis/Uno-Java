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
            System.out.println("Pick a color");
            System.out.println("1: RED\n2: BLUE\n3: GREEN\n4: YELLOW");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            this.color = game.getColors().get(choice - 1);
            System.out.println("the color has changed to " + game.getColors().get(choice - 1));
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
