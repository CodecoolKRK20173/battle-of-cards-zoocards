import java.io.FileNotFoundException;


public class BattleOfCards {


    public static void main(String[] args) throws FileNotFoundException {

       Game game = new Game("animals.csv");

       System.out.println(game.deck.deck.get(4).getSpeed());
        
    }
}