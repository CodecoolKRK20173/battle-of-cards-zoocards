import java.net.Socket;
import java.util.Scanner;

public class View {
    
    public static void print(String string){
        System.out.println(string);
    }

    static int askForNumberOfPlayers(){
        
        Scanner scan =  new Scanner(System.in);

        View.print("Enter number of players (2-5): ");        
        int choice = scan.nextInt();
        scan.close();

        return choice;
    }

    public static void printCard(Card card){

        System.out.println("Animal: " + card.getName());
        System.out.println("Speed: " + card.getSpeed());
        System.out.println("Height: " + card.getHeight());
        System.out.println("Strenght: " + card.getStrenght());
        System.out.println("Life Expectancy: " + card.getLifeExpectancy());
    }
    
}