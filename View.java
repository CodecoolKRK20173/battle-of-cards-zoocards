import java.util.Scanner;

class View {

    static Scanner scan = new Scanner(System.in);
    static int featureChoice;
    static int noOfPlayersChoice;

    
    public static void print(String string){
        System.out.println(string);
    }

    public static void print(int intId){
        System.out.println(intId);
    }

    public static void printCard(Card card){

        System.out.println("Animal: " + card.getName());
        System.out.println("1. Speed: " + card.getSpeed());
        System.out.println("2. Height: " + card.getHeight());
        System.out.println("3. Strenght: " + card.getStrenght());
        System.out.println("4. Life Expectancy: " + card.getLifeExpectancy());
    }

    static int decideWhichFeature(){

        View.print("Please select which feature to fight with...");
        View.print("1. Speed \n2. Height \n3. Strenght \n4. Life Expectancy");

        if (scan.hasNext()){
            
            featureChoice = scan.nextInt();
            scan.nextLine();
        }
        return featureChoice;
    }

    static int askForNumberOfPlayers(){
        
        View.print("Enter number of players (2-5): ");   
             
        int noOfPlayersChoice = scan.nextInt();

        return noOfPlayersChoice;
    }
}
