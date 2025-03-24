package fr.ynov.uno.game;

import fr.ynov.uno.game.card.*;
import fr.ynov.uno.game.player.Player;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Card> usedCards;
    private List<Card> leftoverCards;
    private int direction;
    private final List<Color> colors;
    private int currentPlayer;
    private List<String> colorNames;

    public Game() {
        this.colors=new ArrayList<>();
        this.colors.add(Color.RED);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.GREEN);
        this.colors.add(Color.YELLOW);
        this.usedCards= new ArrayList<>();
        this.leftoverCards= new ArrayList<>();
        this.players= new ArrayList<>();
        direction=1;
        this.currentPlayer=0;
        this.colorNames = new ArrayList<>();
        colorNames.add("RED");
        colorNames.add("BLUE");
        colorNames.add("GREEN");
        colorNames.add("YELLOW");
    }

    public void setDirection(int d) {
        direction = d;
    }
    public int getDirection() {
        return direction;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Color> getColors() {
        return colors;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Card> getLeftoverCards() {
        return leftoverCards;
    }

    public List<Card> getUsedCards(){
        return usedCards;
    }

    private void setupCards(){
        for(int j = 0; j<2; j++) {
            for (int i = j; i < 10; i++) {
                for(int k = 0; k<4; k++){
                    leftoverCards.add(new RegularCard(colorNames.get(k)+i,"regular",colors.get(k),i));
                }
            }
            for(int l = 0; l<4; l++){
                leftoverCards.add(new SkipCard(colorNames.get(l)+"skip","power",colors.get(l),null));
                leftoverCards.add(new ReverseCard(colorNames.get(l)+"reverse","power",colors.get(l),null));
                leftoverCards.add(new Plus2Card(colorNames.get(l)+"plus2","power",colors.get(l),null));
            }
            leftoverCards.add(new Plus4Card("plus4","power",null,null));
            leftoverCards.add(new Plus4Card("plus4","power",null,null));
            leftoverCards.add(new ChangeColorCard("change color","power",null,null));
            leftoverCards.add(new ChangeColorCard("change color","power",null,null));
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

    private void placeCard(int player, int choice){
        Card c=players.get(player).getPlayerCards().get(choice);
        if (c.canBePlacedOn(usedCards.getLast())) {
            if (Objects.equals(c.getType(), "power")){
                PowerCard c2=(PowerCard)c;
                c2.usePower(this);
            }
            usedCards.add(players.get(player).playCard(choice));
        }else{
            System.out.println("You can't play that card");
            round();
        }
    }

    private Integer round(){
        System.out.print("Top Card:");
        usedCards.getLast().show();
        System.out.println("used cards:"+usedCards.size());
        System.out.println("0: Pickup");
        players.getFirst().showCards();
        Scanner sc=new Scanner(System.in);
        System.out.println("Which Card would you like to play");
        int choice=sc.nextInt();
        if (choice==0){
            getPlayers().getFirst().getPlayerCards().add(takeCard());
        }else {
            placeCard(0, choice - 1);
        }
        currentPlayer++;
        for (;this.currentPlayer < players.size();currentPlayer++) {
            boolean placedCard = false;
            for (int i=0;i < players.get(currentPlayer).getPlayerCards().size(); i++) {
                if (players.get(currentPlayer).getPlayerCards().get(i).canBePlacedOn(usedCards.getLast())) {
                    placeCard(this.currentPlayer,i);
                    placedCard = true;
                    break;
                }
            }
            if (!placedCard) {
                players.get(currentPlayer).getPlayerCards().add(takeCard());
            }
            if (players.get(currentPlayer).getPlayerCards().isEmpty()) {
                return currentPlayer;
            }
            System.out.println("player "+currentPlayer+" has "+players.get(currentPlayer).getPlayerCards().size()+" cards left");
        }
        this.currentPlayer=0;
        return null;
    }



    public void startGame() {
        setupCards();
        dealCards();
        Integer winner=round();
        while (winner == null) {
            winner = round();
        }
        System.out.println("The Winner is player "+winner);
    }
}
