import java.util.Scanner;

public class Player {
    
    Hand hand = new Hand();

    Player(){

    }

    void addCard(Card card){

        this.hand.addCard(card);
    }

    Card layCardOnTable(){

        return this.hand.giveCard();
    }

    int decideWhichFeature(){

        Scanner scan =  new Scanner(System.in);

        View.print("Please select which feature to fight with...");
        View.print("1. Speed \n 2. Height \n 3. Strenght \n 4. Life Expectancy");
        
        int choice = scan.nextInt();
        scan.close();

        return choice;
    }

    boolean isLose(){

        return hand.isLose();
    }
        
}