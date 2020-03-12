import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game implements Comparable {

    Deck deck = new Deck(fileName);
    Player player1 = new Player();
    Player player2 = new Player();
    Table table = new Table();
    Dealer dealer = new Dealer();

    List<Player> players = new ArrayList<>();

    Game(String fileName) throws FileNotFoundException {
        players.add(player1);
        players.add(player2);
    }

    public void dealCards() {

        this.dealer.drawCardsFromDeck(player1, deck);
        this.dealer.drawCardsFromDeck(player2, deck);

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

    public void round(){


        while(checkIfPlayerLost()){
            //+clean code to be made 

            View.printCard(player1.layCardOnTable());
            int player1Decision = player1.decideWhichFeature();

            View.printCard(player2.layCardOnTable());

            Card player1Card = player1.layCardOnTable();
            Card player2Card = player2.layCardOnTable();


        }


    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

    public int 

}
