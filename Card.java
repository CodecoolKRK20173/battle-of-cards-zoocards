public class Card implements Comparable<Card> {

    private int speed;
    private int height;
    private int strenght;
    private int lifeExpectancy;
    private String name;
    private int whooseCardIsThisNow;


    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getSpeed()
    {
        return speed;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public void setStrenght(int strenght)
    {
        this.strenght = strenght;
    }

    public int getStrenght()
    {
        return strenght;
    }

    public void setLifeExpectancy(int lifeExpectancy)
    {
        this.lifeExpectancy = lifeExpectancy;
    }

    public int getLifeExpectancy()
    {
        return lifeExpectancy;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    int getWooseCardIsThisNow(){

        return this.whooseCardIsThisNow;
    }

    void setWooseCardIsThisNow(int PlayerID){

        this.whooseCardIsThisNow = PlayerID;
    }

    @Override
    public int compareTo(Card card) {
        return 0;
    }
    public String toString(){
        return "Card name: " + name + " | speed: " + speed + " | height: " + height + " | strength: " + strenght + " | lifeExpectancy: " + lifeExpectancy; 

    }
}