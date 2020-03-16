import java.util.Scanner;

public class Player {
    
    Hand hand = new Hand();
    int id;

    Player(int id){
        
        this.id = id;
    }

    void addCard(Card card){

        this.hand.addCard(card);
    }

    Card layCardOnTable(){

        return this.hand.giveCard();
    }

    boolean isLose(){

        return hand.isLose();
    }

    int getPlayerId(){
        return id;
    }

    int getCardsCount(){
        return hand.getCardsCount();
    }

    Card showTopCard(){

        return this.hand.showTopCard();
    }
        
}