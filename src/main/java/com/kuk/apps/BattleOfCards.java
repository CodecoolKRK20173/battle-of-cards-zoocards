package com.kuk.apps;

import java.io.FileNotFoundException;

public class BattleOfCards {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "src/main/resources/animals.xml";
        //String fileName = "animals.csv";
        View view = new View();

        view.print("");
        view.print("---Battle of Cards: Zoo Edition---");
        view.print("");

        Game game = new Game(new Deck(new CardXMLDao(fileName).getCards()));
        game.startGame();

        // Game game = new Game(new Deck(new CardCSVDao(fileName).getCards()));
        // game.startGame();
        

    }
}