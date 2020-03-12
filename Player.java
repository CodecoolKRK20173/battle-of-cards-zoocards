public class Player {
    
    Hand hand;

    Player(){

        hand = new Hand();

    }

    void addCardToHand(Card card){

        this.hand.addCard(card);
    }

    Card layCardOnTable(){

        return this.hand.giveCard();
    }

    int decideWhichFeature(){

    }
}