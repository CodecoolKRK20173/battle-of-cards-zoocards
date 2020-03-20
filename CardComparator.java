import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private String feature;

    public CardComparator(String feature) {
        this.feature = feature;
    }

    @Override
    public int compare(Card card1, Card card2) {
        if (feature.equals("SPEED")) {
            return card1.getSpeed() - card2.getSpeed();
        } else if (feature.equals("HEIGHT")) {
            return card1.getHeight() - card2.getHeight();
        } else if (feature.equals("STRENGTH")){
            return card1.getHeight() - card2.getStrenght();
        } else if (feature.equals("LIFE EXPECTANCY")){
            return card1.getHeight() - card2.getLifeExpectancy();
        } else{
            throw new IllegalArgumentException("Unrecognized feature: " + feature);
        }
    }
}

