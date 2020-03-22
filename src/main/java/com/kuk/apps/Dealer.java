package com.kuk.apps;

import java.util.ArrayList;
import java.util.Random;

public class Dealer extends Player {
    private Hand hand = new Hand();
    private int id;
    private int comparationResult;
    private Deck deck;
    private CardComparator comparator;

    Dealer(Deck deck, int id) {
        this.deck = deck;
        this.id = id;
    }

    public void dealCardsToPlayers(ArrayList<Player> players) {
        int numberOfCardsPerPlayer = deck.getCardsSize() / players.size();

        for (Player player : players) {
            for (int i = 0; i < numberOfCardsPerPlayer - 1; i++) {
                Random randomGenerator = new Random();
                int index = randomGenerator.nextInt(deck.getCardsSize() - 1);

                Card drawnCard = deck.getCards().get(index);
                deck.getCards().remove(index);

                player.addCard(drawnCard);
            }
        }
    }

    public ArrayList<Integer> getWinner(ArrayList<Card> cardsOnTable, int playerDecision) {
        // creating ArrayList of IDs of all the winners (because there might be exequo
        // winners!)
        ArrayList<Integer> winnersIds = new ArrayList<Integer>();

        // bubble-sorting cardsOnTable
        Card temp;
        int change = 1;

        while (change > 0) {
            change = 0;
            for (int i = 0; i < cardsOnTable.size() - 1; i++) {

                // switch for different features of cards to sort with (which feature to sort with)
                if (playerDecision == 1) {
                    comparationResult = new CardComparator("SPEED")
                            .compare(cardsOnTable.get(i), cardsOnTable.get(i + 1));
                } else if (playerDecision == 2) {
                    comparationResult = Integer.compare(cardsOnTable.get(i).getHeight(), cardsOnTable.get(i + 1).getHeight());
                } else if (playerDecision == 3) {
                    comparationResult = Integer.compare(cardsOnTable.get(i).getStrenght(), cardsOnTable.get(i + 1).getStrenght());
                } else if (playerDecision == 4) {
                    comparationResult = Integer.compare(cardsOnTable.get(i).getLifeExpectancy(), cardsOnTable.get(i + 1).getLifeExpectancy());
                }

                // continuation of bubble-sorting
                if (comparationResult < 0) {
                    temp = cardsOnTable.get(i + 1);
                    cardsOnTable.set(i + 1, cardsOnTable.get(i));
                    cardsOnTable.set(i, temp);
                    change++;
                }
            }
        }

        // adding ID of the player whoos card is on top of the sorted cardsOnTable list
        winnersIds.add(cardsOnTable.get(0).getWooseCardIsThisNow());

        // checking if there are exequo winners
        // first checking if the two top cards (in the sorted cardsOnTable) have equal
        // values in any of the features
        // firstly doing it for the case when speed was the feature to fight with...
        switch (playerDecision) {
            case 1:
                if (cardsOnTable.get(0).getSpeed() == cardsOnTable.get(1).getSpeed()) {
                    // then iterating through sorted cardsOnTable list and checking (from first to
                    // last card) if they have the
                    // same value as the first. If yes, than adding ID of the player to who this
                    // card belongs to the list
                    // of exequoWinnersIds list
                    for (int j = 1; j < cardsOnTable.size() - 1; j++) {
                        if (cardsOnTable.get(0).getSpeed() == cardsOnTable.get(j).getSpeed()) {
                            winnersIds.add(cardsOnTable.get(j).getWooseCardIsThisNow());
                        }
                    }
                }

                // Then exactly the same but for the remaining other features...
            case 2:
                if (cardsOnTable.get(0).getHeight() == cardsOnTable.get(1).getHeight()) {
                    for (int j = 1; j < cardsOnTable.size() - 1; j++) {
                        if (cardsOnTable.get(0).getHeight() == cardsOnTable.get(j).getHeight()) {
                            winnersIds.add(cardsOnTable.get(j).getWooseCardIsThisNow());
                        }
                    }
                }
            case 3:
                if (cardsOnTable.get(0).getStrenght() == cardsOnTable.get(1).getStrenght()) {
                    for (int j = 1; j < cardsOnTable.size() - 1; j++) {
                        if (cardsOnTable.get(0).getStrenght() == cardsOnTable.get(j).getStrenght()) {
                            winnersIds.add(cardsOnTable.get(j).getWooseCardIsThisNow());
                        }
                    }
                }
            case 4:
                if (cardsOnTable.get(0).getLifeExpectancy() == cardsOnTable.get(1).getLifeExpectancy()) {
                    for (int j = 1; j < cardsOnTable.size() - 1; j++) {
                        if (cardsOnTable.get(0).getLifeExpectancy() == cardsOnTable.get(j).getLifeExpectancy()) {
                            winnersIds.add(cardsOnTable.get(j).getWooseCardIsThisNow());
                        }
                    }
                }
        }
        return winnersIds;
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
