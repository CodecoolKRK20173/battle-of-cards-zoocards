import java.io.FileNotFoundException;

public class BattleOfCards {

    public static void main(String[] args) throws FileNotFoundException {
        
        String fileName = "animals.csv";

        View.print("");
        View.print("---Battle of Cards: Zoo Edition---");
        View.print("");

        new Game(fileName);

    }
}