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
        String str = " "; 

        System.out.println("----------------------");
        System.out.println("|Animal: " + card.getName() + str.repeat(13 - card.getName().length()) + "|");
        System.out.println("----------------------");
        System.out.println("|Speed: " + card.getSpeed()+ str.repeat(14 - countDigit(card.getSpeed())) + "|");
        System.out.println("|Height: " + card.getHeight()+ str.repeat(13 - countDigit(card.getHeight())) + "|");
        System.out.println("|Strenght: " + card.getStrenght()+ str.repeat(11 - countDigit(card.getStrenght())) + "|");
        System.out.println("|Life Expectancy: " + card.getLifeExpectancy()+ str.repeat(4 - countDigit(card.getLifeExpectancy())) + "|");
        System.out.println("----------------------");
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


    static int countDigit(long n) 
    { 
        int count = 0; 
        while (n != 0) { 
            n = n / 10; 
            ++count; 
        } 
        return count; 
    } 
}
