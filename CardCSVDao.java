import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardCSVDao implements CardDao {

    private String fileName;

    public CardCSVDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Card> getCards() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        List<Card> cards = new ArrayList<>();

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

            cards.add(card);
        }

        sc.close(); // closes the scanner

        return cards;
    }

}
