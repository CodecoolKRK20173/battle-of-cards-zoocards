import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {
    
    List<Card> drawnCards = new ArrayList<Card>();

    Dealer(){

    }

    void drawCardsFromDeck(Player player, Deck deck){

        List<Card> drawnCards = new ArrayList<>();

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(deck.deck.size() - 1);
        Card drawnCard = deck.deck.get(index);
        deck.deck.remove(index);
        drawnCards.add(drawnCard);

        for (Card card : drawnCards){
            
            player.addCardToHand(card);
        }
    }
}

