import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deck{

    List<Card> deck = new ArrayList<Card>();

    Deck(String fileName) throws FileNotFoundException {
 
        createDeck(fileName);

    }

    public void createDeck(String fileName) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNext()) // returns a boolean value
        {
            String[] cardContent = sc.nextLine().split(",");
            
            int speed = Integer.parseInt(cardContent[1]);
            int height = Integer.parseInt(cardContent[2]);
            int strenght = Integer.parseInt(cardContent[3]);
            int lifeExpectancy = Integer.parseInt(cardContent[4]);

            Card card = new Card();
            
            card.setName(cardContent[0]);
            card.setSpeed(speed);
            card.setHeight(height);
            card.setStrenght(strenght);
            card.setLifeExpectancy(lifeExpectancy);

            deck.add(card);
        }

        sc.close(); // closes the scanner
    }
    
    public int getNumOfCards(){
        return deck.size();
    }
}

