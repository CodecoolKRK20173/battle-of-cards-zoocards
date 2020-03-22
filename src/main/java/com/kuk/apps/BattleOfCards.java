package com.kuk.apps;

import java.io.FileNotFoundException;

public class BattleOfCards {
    public static void main(String[] args) throws FileNotFoundException {
        String fileNameXML = "src/main/resources/animals.xml";
        String fileNameCSV = "src/main/resources/animals.csv";

        View view = new View();
        view.print("");
        view.print("---Battle of Cards: Zoo Edition---");
        view.print("");

        new Game(new Deck(new CardXMLDao(fileNameXML).getCards()))
                .startGame();

    }
}