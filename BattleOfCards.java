import java.io.FileNotFoundException;


public class BattleOfCards {


    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "animals.csv";
        Game game = new Game(fileName);

        System.out.println(game.deck.deck.get(4).getSpeed());

    }
}