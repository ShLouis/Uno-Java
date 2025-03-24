package fr.ynov.uno.game.player;

import fr.ynov.uno.game.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> playerCards;

    public Player(){
        playerCards= new ArrayList<>();
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void showCards(){
        for (int i=0; i<playerCards.size(); i++) {
            System.out.println((i+1)+": "+playerCards.get(i).getName());
        }
    }

    public Card playCard(int cardNumber){
        Card choice=playerCards.get(cardNumber);
        playerCards.remove(cardNumber);
        return choice;
    }
    public void pickupCard(){
    }

}
