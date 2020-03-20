import java.util.Iterator;

public class Card implements Comparable<Card> {

    Integer speed;
    Integer height;
    Integer strenght;
    Integer lifeExpectancy;
    String name;
    int whooseCardIsThisNow;
    int featurToCompare;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int getWooseCardIsThisNow() {

        return this.whooseCardIsThisNow;
    }

    void setWooseCardIsThisNow(int PlayerID) {

        this.whooseCardIsThisNow = PlayerID;
    }

    @Override
    public int compareTo(Card otherCard) {
        if (featurToCompare == 1) {
            return this.speed.compareTo(otherCard.getSpeed());
        } else if (featurToCompare == 2) {
            return this.height.compareTo(otherCard.getHeight());
        } else if (featurToCompare == 3) {
            return this.strenght.compareTo(otherCard.getStrenght());
        } else {
            return this.lifeExpectancy.compareTo(otherCard.getLifeExpectancy());
        }
    }

    public String toString() {
        return "Card name: " + name + " | speed: " + speed + " | height: " + height + " | strength: " + strenght
                + " | lifeExpectancy: " + lifeExpectancy;

    }

}