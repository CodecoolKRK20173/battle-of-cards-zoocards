import java.io.FileNotFoundException;

public class Game {

    public Deck deck;

    Game(String fileName) throws FileNotFoundException {

        this.deck = new Deck(fileName);
    

    }

  
    


}
