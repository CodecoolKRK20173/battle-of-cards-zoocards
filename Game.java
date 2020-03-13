import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game implements Comparable {

    String fileName = "animal.csv";
    Deck deck = new Deck(fileName);
    Table table = new Table();
    Dealer dealer = new Dealer();
    List<Player> players = new ArrayList<>();

    Game(String fileName) throws FileNotFoundException {

        // introduction
        View.print("---Zoo Battle of Cards---");
        View.print("");

        // ask for number of players
        int numberOFPlayers = View.askForNumberOfPlayers();

        // adding players
        for (int i = 0; i < numberOFPlayers; i++){
            players.add(new Player(i+1));
        }

        // dealing cards to players
        dealCards();

        //
    }


    public void dealCards() {

        for (Player player : players){
            dealer.drawCardsFromDeck(player, deck);
        }
    }

    public void round(Player player1, Player player2){

        while(checkIfPlayerLost()){
            //+clean code to be made 

            View.printCard(player1.layCardOnTable());
            int player1Decision = player1.decideWhichFeature();

            View.printCard(player2.layCardOnTable());

            Card player1Card = player1.layCardOnTable();
            Card player2Card = player2.layCardOnTable();
        }
    }

    public void playersChoices(Player player1, Player player2){

        View.printCard(player1.layCardOnTable());
        int player1Decision = player1.decideWhichFeature();

        View.printCard(player2.layCardOnTable());

        Card player1Card = player1.layCardOnTable();
        Card player2Card = player2.layCardOnTable();
    }

    public boolean checkIfPlayerLost() {

        for (Player player : players) {
            if (player.isLose()) {
                return false;
            } else {
                ;
            }
        return true;
        }
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

    public int 

}
