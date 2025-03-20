package fr.ynov.uno.game;

import fr.ynov.uno.game.card.*;
import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private List<Card> usedCards;
    private List<Card> leftoverCards;
    private int currentPlayer;
    static int direction;
    private final List<Color> colors;

    public Game() {
        this.colors=new ArrayList<>();
        this.colors.add(Color.RED);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.GREEN);
        this.colors.add(Color.YELLOW);
        this.usedCards= new ArrayList<>();
        this.leftoverCards= new ArrayList<>();
        this.players= new ArrayList<>();
        this.currentPlayer=0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Card> getLeftoverCards() {
        return leftoverCards;
    }

    public List<Card> getUsedCards(){
        return usedCards;
    }

    public void changeDirection() {
        direction = -direction;
    }

    private void setupCards(){
        List<String> strColors = new ArrayList<>();
        strColors.add("RED");
        strColors.add("BLUE");
        strColors.add("GREEN");
        strColors.add("YELLOW");
        for(int j = 0; j<2; j++) {
            for (int i = j; i < 10; i++) {
                for(int k = 0; k<4; k++){
                    leftoverCards.add(new RegularCard(strColors.get(k)+i,colors.get(k),i));
                }
            }
            for(int l = 0; l<4; l++){
                leftoverCards.add(new SkipCard(strColors.get(l)+"skip",colors.get(l),null));
                leftoverCards.add(new ReverseCard(strColors.get(l)+"reverse",colors.get(l),null));
                leftoverCards.add(new Plus2Card(strColors.get(l)+"plus2",colors.get(l),null));
            }
            leftoverCards.add(new Plus4Card("plus4",null,null));
            leftoverCards.add(new Plus4Card("plus4",null,null));
            leftoverCards.add(new ChangeColorCard("change color",null,null));
            leftoverCards.add(new ChangeColorCard("chane color",null,null));
        }
        Collections.shuffle(leftoverCards);
    }

    public Card takeCard(){
        if (!this.leftoverCards.isEmpty()) {
            Card pickedCard = this.leftoverCards.getFirst();
            this.leftoverCards.removeFirst();
            return pickedCard;
        }
        return null;
    }

    private void dealCards(){
        this.usedCards.add(takeCard());
        for (int i=0; i<4; i++) {
            this.players.add(new Player());
            for (int j=0; j<7; j++) {
                this.players.get(i).getPlayerCards().add(takeCard());
            }
        }
    }

    private void round(){
        System.out.print("Top Card:");
        usedCards.getLast().show();
        players.get(currentPlayer).showCards();
        Scanner sc=new Scanner(System.in);
        System.out.println("Which Card would you like to play");
        int choice=sc.nextInt();
        if (players.get(currentPlayer).getPlayerCards().get(choice).canBePlacedOn(usedCards.getLast())) {
            usedCards.add(players.get(currentPlayer).playCard(choice));
        }else{
            System.out.println("You can't play that card");
            round();
        }
    }



    public void startGame(){
        setupCards();
        dealCards();
        round();
    }
}
