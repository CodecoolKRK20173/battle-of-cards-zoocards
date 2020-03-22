package com.kuk.apps;

import java.util.List;

public class Deck {

    private List<Card> cards;

    Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardsSize() {
        return cards.size();
    }
}

