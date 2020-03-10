import java.util.Comparator;

public class Card implements Comparator {

    int speed;
    int height;
    int strenght;
    int lifeExpectancy;
    String name;


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

    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        return 0;
    }


}