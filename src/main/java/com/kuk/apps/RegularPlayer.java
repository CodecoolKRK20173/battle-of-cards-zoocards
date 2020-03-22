package com.kuk.apps;

public class RegularPlayer extends Player{
    private Hand hand = new Hand();
    private int id;

    RegularPlayer(int id) {
        this.id = id;
    }

    public void addCard(Card card) {
        hand.addCard(card, id);
    }

    public Card layCardOnTable() {
        return hand.giveCard();
    }

    public boolean isLose() {
        return hand.isLose();
    }

    public int getPlayerId() {
        return id;
    }

    public int getCardsCount() {
        return hand.getCardsCount();
    }

    public Card showTopCard() {
        return hand.showTopCard();
    }

}