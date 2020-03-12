import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Dealer implements Comparator<Card> {
    
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

        int index1= randomGenerator.nextInt(deck.deck.size() - 1);
        Card drawnCard1 = deck.deck.get(index1);
        deck.deck.remove(index1);
        drawnCards.add(drawnCard1);

        int index2 = randomGenerator.nextInt(deck.deck.size() - 1);
        Card drawnCard2 = deck.deck.get(index2);
        deck.deck.remove(index2);
        drawnCards.add(drawnCard2);
        
        int index3 = randomGenerator.nextInt(deck.deck.size() - 1);
        Card drawnCard3 = deck.deck.get(index3);
        deck.deck.remove(index3);
        drawnCards.add(drawnCard3);
       

        for (Card card : drawnCards){
            player.addCard(card);
        }
    }

	@Override
	public int compare(Card o1, Card o2) {
        // TODO Auto-generated method stub
        
        if(choice == 1){
            return Integer.compare(o1.getSpeed(), o2.getSpeed());
        }
        else if(choice == 2){
            return Integer.compare(o1.getHeight(), o2.getHeight());
        }
        else if(choice == 3){
            return Integer.compare(o1.getStrenght(), o2.getStrenght());
        }
        else if(choice == 4){
            return Integer.compare(o1.getLifeExpectancy(), o2.getLifeExpectancy());
        }
		
	}

}

