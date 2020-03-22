package com.kuk.apps;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    private  List<Card> hand = new ArrayList<>();

    Hand(){
    }

    public void addCard(Card card, int playerId){
        card.setWooseCardIsThisNow(playerId);
        this.hand.add(0, card);
    }

    public Card giveCard(){

        Card cardToGive = hand.get(hand.size() - 1);

        hand.remove(hand.size() - 1);

        return cardToGive;
    }

    public boolean isLose(){

        return hand.isEmpty();
    }

    public int getCardsCount(){
        return hand.size();
    }
    
    public Card showTopCard(){
        return hand.get(hand.size() - 1);
    }
    
}