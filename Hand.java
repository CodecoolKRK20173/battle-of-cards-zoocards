import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    List<Card> hand = new ArrayList<>();

    Hand(){
    }

    void addCard(Card card, int playerId){
        card.setWooseCardIsThisNow(playerId);
        this.hand.add(0, card);
    }

    Card giveCard(){

        Card cardToGive = hand.get(hand.size() - 1);

        hand.remove(hand.size() - 1);

        return cardToGive;
    }

    boolean isLose(){

        return hand.isEmpty();
    }

    int getCardsCount(){
        return hand.size();
    }
    
    Card showTopCard(){
        return hand.get(hand.size() - 1);
    }
    
}