import java.io.FileNotFoundException;

public class BattleOfCards {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "animals.csv";
        View view = new View();

        view.print("");
        view.print("---Battle of Cards: Zoo Edition---");
        view.print("");

        Game game = new Game(new Deck(new CardCSVDao(fileName).getCards()));
        game.startGame();        

    }
}