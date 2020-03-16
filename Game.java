import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Deck deck;
    Dealer dealer;
    int cardComparisonResult;
    ArrayList<Player> players = new ArrayList<Player>();

    Game(String fileName) throws FileNotFoundException {

        deck = new Deck(fileName);
        dealer = new Dealer(deck);

        // ask for number of players
        int numberOFPlayers = View.askForNumberOfPlayers();

        // adding players
        for (int i = 0; i < numberOFPlayers; i++){

            players.add(new Player(i+1));
        }
        // dealing cards
        dealCards();
        
        // game
        while (true){

            for (int i = 0; i < players.size(); i++){
                for (int x = 0; x<30; x++){
                    System.out.println("\n");
                }
                round(i , players);
                if (checkGameStatus()){
                    break;
                } 
            }
        }

  
    }

    public void dealCards() {

        for (Player player : players){
            dealer.drawCardsFromDeck(player, deck);
        }
    }

    public ArrayList<Card> round(int currentPlayerIndex, ArrayList<Player> players){

        List<Card> cardsOnTable = new ArrayList<Card>();

        Player playerToDecide = players.get(currentPlayerIndex);

        //+clean code to be made 
        ArrayList<Card> tempCardStack = new ArrayList<Card>();

        View.print("");
        View.print("--Player " + playerToDecide.getPlayerId() + "--");
        View.print("");
        View.printCard(playerToDecide.showTopCard());
        View.print("");

        //View.printCard(player2.showTopCard());
        View.print("");

        // calculating the winning card
        for (Player player : players){
            cardsOnTable.add(player.layCardOnTable());
        }
        int player1Decision = 0;
        while (true){

            player1Decision = View.decideWhichFeature();

            if(player1Decision == 1){
                //cardComparisonResult = dealer.compare(player1Card.getSpeed(), player2Card.getSpeed());

                Card temp;
                int change = 1;
                while(change > 0){
                    change = 0;
                    for(int i=0; i<cardsOnTable.size()-1; i++){
                        if(dealer.compare(cardsOnTable.get(i).getSpeed(), cardsOnTable.get(i+1).getSpeed()) > 0){
                        temp = cardsOnTable.get(i+1);
                        cardsOnTable.set(i+1, cardsOnTable.get(i));
                        cardsOnTable.set(i, temp);
                        change++;
                        }
                    }
                }
                break;
            }

            else if(player1Decision == 2){
                // cardComparisonResult = dealer.compare(player1Card.getHeight(), player2Card.getHeight());
                Card temp;
                int change = 1;
                while(change > 0){
                    change = 0;
                    for(int i=0; i<cardsOnTable.size()-1; i++){
                        if(dealer.compare(cardsOnTable.get(i).getHeight(), cardsOnTable.get(i+1).getHeight()) > 0){
                        temp = cardsOnTable.get(i+1);
                        cardsOnTable.set(i+1, cardsOnTable.get(i));
                        cardsOnTable.set(i, temp);
                        change++;
                        }
                    }
                }
                break;
            }

            else if(player1Decision == 3){
                // cardComparisonResult = dealer.compare(player1Card.getStrenght(), player2Card.getStrenght());
                Card temp;
                int change = 1;
                while(change > 0){
                    change = 0;
                    for(int i=0; i<cardsOnTable.size()-1; i++){
                        if(dealer.compare(cardsOnTable.get(i).getStrenght(), cardsOnTable.get(i+1).getStrenght()) > 0){
                        temp = cardsOnTable.get(i+1);
                        cardsOnTable.set(i+1, cardsOnTable.get(i));
                        cardsOnTable.set(i, temp);
                        change++;
                        }
                    }
                }
                break;
            }

            else if(player1Decision == 4){
                // cardComparisonResult = dealer.compare(player1Card.getLifeExpectancy(), player2Card.getLifeExpectancy());
                Card temp;
                int change = 1;
                while(change > 0){
                    change = 0;
                    for(int i=0; i<cardsOnTable.size()-1; i++){
                        if(dealer.compare(cardsOnTable.get(i).getLifeExpectancy(), cardsOnTable.get(i+1).getLifeExpectancy()) > 0){
                        temp = cardsOnTable.get(i+1);
                        cardsOnTable.set(i+1, cardsOnTable.get(i));
                        cardsOnTable.set(i, temp);
                        change++;
                        }
                    }
                }
                break;
            }
            else{
                View.print("No such choice!");
            }
        }

        // checking if there are exequo winner cards


        // checking whose card is first in sorted cardsOnTable arraylist
        int winnerId = cardsOnTable.get(0).getWooseCardIsThisNow();

        // finding the winner
        for (Player player : players){
            if (player.getPlayerId() == winnerId){
                View.print("Player " + player.getPlayerId() + " won the round!");
                // adding cards to winner
                for (Card card : cardsOnTable){
                    player.addCard(card);
                    cardsOnTable.remove(card);
                }
            }
            else {
                ;
            }
        }

        return tempCardStack;
    }

    public boolean checkGameStatus() {
        for (Player player : players) {
            if (player.isLose()){
                View.print("Congratulations! Player " + player.getPlayerId() + " has lost");
                players.remove(player);
                if (players.size() == 1){
                    return true;
                }
            }
            else {
                ;
            }
        }
        return false;
    }
}