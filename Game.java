import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {

    Deck deck;
    Dealer dealer;
    ArrayList<Player> players = new ArrayList<Player>();
    int cardComparisonResult;
    ArrayList<Card> tempCardStack = new ArrayList<>();

    Game(String fileName) throws FileNotFoundException {

        deck = new Deck(fileName);
        dealer = new Dealer(deck);

        // ask for number of players
        int numberOFPlayers = View.askForNumberOfPlayers();

        // adding players to 'players' ArrayList
        for (int i = 0; i < numberOFPlayers; i++){

            players.add(new Player(i+1));
        }

        // dealing cards to players
        dealer.dealCardsToPlayers(players, deck);

        // Game
        while (!(players.size() == 1)){

            for (int i = 0; i < players.size(); i++){

                // printowanie ilości kart kazdego z graczy dla testów
                if (checkGameStatus()){
                    try{
                        // display no of cards for each player
                        for (Player player : players){
                            View.print("Player " + player.getPlayerId() + " no of cards: " + player.getCardsCount());
                        }

                        round(players.get(i), players);
                    }
                    catch(IndexOutOfBoundsException e){
                        continue;
                    }
                }
                else{
                    break;
                }
            }
        }
    }


    public void round(Player playerWhoseTurn, ArrayList<Player> players){

        // displaying template with name of the current player
        View.print("");
        View.print("--Player " + playerWhoseTurn.getPlayerId() + "--");
        View.print("");

        // displaying decisive player's card
        View.printCard(playerWhoseTurn.showTopCard());
        View.print("\n\n");
        
        // creating list of cards currently in game (table)
        ArrayList<Card> cardsOnTable = new ArrayList<Card>();

        // All players lay their cards on table
        for (Player player : players){
            cardsOnTable.add(player.layCardOnTable());
        }

        // Actual round

            // Asking player for decision which feature to fight with
        int playerDecision;

        while (true){

            // decisive player decides which feature to fight with
            playerDecision = View.decideWhichFeature();

            // possible decisions
            int[] possibleChoices = {1, 2, 3, 4};

            // check if player choose existing option
            if (!checkIfValueInArray(possibleChoices, playerDecision)){
                View.print("No such choice! Try again!");
            }
            else{
                break;
            }
        }

        // Dealer checks who won (there might be exequo winners!)
        ArrayList<Integer> winnersIds = dealer.getWinner(cardsOnTable, playerDecision);

        // if there are no exequo winners, so there is only one winner:
        if (winnersIds.size() == 1){

            // display message who won
            View.print("\nPlayer " + winnersIds.get(0) + " won the round!");

            //add cards from cardsOnTable to winner's hand
            for (Card card : cardsOnTable){
                for (Player player : players){
                    if (player.getPlayerId() == winnersIds.get(0)){
                        player.addCard(card);
                    }
                }
            }
            // clear cardsOnTable
            cardsOnTable.clear();

            //add cards from tempCardStack (if ther are any) to winner's hand
            for (Card card : tempCardStack){
                for (Player player : players){
                    if (player.getPlayerId() == winnersIds.get(0)){
                        player.addCard(card);
                    }
                }
            }
            // clear tempCardStack
            tempCardStack.clear();

        }

        // when there are exequo winners:
        else if (winnersIds.size() > 1){

            // Nobody gets the cards, instead cards go to temporary stack untill someone wins them
            // in the next round
            for (Card card : cardsOnTable){
                tempCardStack.add(card);
            }
            // display who won (for example "Players 1, 2, 3 exequo won the round")
            View.printExequoWinners(winnersIds);
        }   
    }

    public boolean checkGameStatus() {
        int i = 0;
        ArrayList<Integer> indexesOfPlayersToBeRemoved = new ArrayList<>();
        for (Player player : players) {
            if (player.isLose()){
                View.print("\nOops! Player " + player.getPlayerId() + " has lost\n");
                indexesOfPlayersToBeRemoved.add(i);
            }
            else {
                ;
            }
            i++;
        }
        // takie coś zeby wywalić graczy którzy zostali bez kart, a podwójna pętla bo mozna robic tylko jedno remove na petle
        for (int j = 0; j<indexesOfPlayersToBeRemoved.size(); j++){
            for (int PlayerIndex : indexesOfPlayersToBeRemoved){
                players.remove(PlayerIndex);
                break;
            }
        }

        if (players.size() == 1){
            View.print("Congratulations Player " + players.get(0).getPlayerId() + "! You have won the game!\n");
            return false;
        }
        else {
            return true; 
        }
    }

    boolean checkIfValueInArray(int[] array, int value){
        for (int i : array) {
            if (value == i) {
                return true;
            }
        }
        return false;
    }
}