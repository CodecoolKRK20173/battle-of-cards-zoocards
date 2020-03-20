import java.util.ArrayList;
import java.util.Scanner;

class View {

    private Scanner scan = new Scanner(System.in);
    private int featureChoice;

    public void print(String string) {
        System.out.println(string);
    }

    public void printNoLine(String string) {
        System.out.print(string);
    }

    public void printNoLine(Integer i) {
        System.out.print(i);
    }

    public void print(int intId) {
        System.out.println(intId);
    }

    public void printCard(Card card) {
        String str = " ";

        System.out.println("----------------------");
        System.out.println("|Animal: " + card.getName() + str.repeat(13 - card.getName().length()) + "|");
        System.out.println("----------------------");
        System.out.println("|Speed: " + card.getSpeed() + str.repeat(14 - countDigit(card.getSpeed())) + "|");
        System.out.println("|Height: " + card.getHeight() + str.repeat(13 - countDigit(card.getHeight())) + "|");
        System.out.println("|Strenght: " + card.getStrenght() + str.repeat(11 - countDigit(card.getStrenght())) + "|");
        System.out.println("|Life Expectancy: " + card.getLifeExpectancy()
                + str.repeat(4 - countDigit(card.getLifeExpectancy())) + "|");
        System.out.println("----------------------");
    }

    public int decideWhichFeature() {

        print("Please select which feature to fight with...");
        print("1. Speed \n2. Height \n3. Strenght \n4. Life Expectancy");

        while (!scan.hasNextInt()) {
            String input = scan.next();
            System.out.printf("\"%s\" is not a valid number.\n1-4 allowed.\n", input);
        }

        return featureChoice = scan.nextInt();

    }


    public int askForNumberOfPlayers() {
        int noOfPlayersChoice;
        System.out.print("Enter number of players (2-5): ");
        while (!scan.hasNextInt()) {
            String input = scan.next();
            System.out.printf("\"%s\" is not a valid number.\n2-5 allowed.\n", input);
        }
        noOfPlayersChoice = scan.nextInt();

        if (noOfPlayersChoice > 1 && noOfPlayersChoice < 6) {
            return noOfPlayersChoice;
        } else {
            System.out.println("\nTry again.\n2-5 allowed.\n");
            return askForNumberOfPlayers();
        }
    }

    public int countDigit(long n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public void printExequoWinners(ArrayList<Integer> winnersIds) {
        print("");
        printNoLine("Players ");
        for (int i = 0; i < winnersIds.size(); i++) {

            if (i == 0) {
                printNoLine(winnersIds.get(i));
            } else if (i == winnersIds.size() - 1) {
                printNoLine(" and " + winnersIds.get(i));
            } else {
                printNoLine(", " + winnersIds.get(i));
            }

        }
        printNoLine(" exequo won the round!\n");
    }
}
