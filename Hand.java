import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    List<Card> hand = new ArrayList<>();

    Hand(){
    }

    void addCard(Card card){

        this.hand.add(0, card);
    }

    Card giveCard(){

        Card cardToGive = hand.get(hand.size() - 1);

        hand.remove(hand.size() - 1);

        return cardToGive;
    }

    int giveNoOfCards(){
        
        return hand.size();
    }


}