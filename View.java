import java.net.Socket;

public class View {
    
    public static void print(String string){
        System.out.println(string);
    }
    
    public static void printCard(Card card){


        System.out.println("Animal: " + card.getName());

        System.out.println("Speed: " + card.getSpeed());

        System.out.println("Height: " + card.getHeight());

        System.out.println("Strenght: " + card.getStrenght());

        System.out.println("Life Expectancy: " + card.getLifeExpectancy());
    }
}