package fr.ynov.uno.game.player;

import fr.ynov.uno.game.Game;
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
    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void showCards(){
        for (Card playerCard : playerCards) {
            playerCard.show();
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
