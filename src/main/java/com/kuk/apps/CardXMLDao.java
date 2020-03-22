package com.kuk.apps;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class CardXMLDao implements CardDao
{
    private ArrayList<Card> cards = new ArrayList<Card>();

    private String fileName;

    public CardXMLDao(String fileName){
        this.fileName = fileName;
    }

    public ArrayList<Card> getCards(){
        try
        {

            //creating a constructor of file class and parsing an XML file  
            File file = new File(fileName);
            //an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("card");

            // nodeList is not iterable, so we are using for loop 
            int cardsCount = 0; 
            for (int itr = 0; itr < nodeList.getLength(); itr++){
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    cardsCount++;
                }
            }

            for (int itr = 0; itr < nodeList.getLength(); itr++){
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;

                    Card card = new Card();

                    card.setName(eElement.getElementsByTagName("card_name").item(0).getTextContent());
                    int speed = Integer.parseInt(eElement.getElementsByTagName("card_speed").item(0).getTextContent());
                    int height = Integer.parseInt(eElement.getElementsByTagName("card_height").item(0).getTextContent());
                    int strength = Integer.parseInt(eElement.getElementsByTagName("card_strength").item(0).getTextContent());
                    int lifeExpectancy = Integer.parseInt(eElement.getElementsByTagName("card_life_expectancy").item(0).getTextContent());

                    card.setSpeed(speed);
                    card.setHeight(height);
                    card.setStrenght(strength);
                    card.setLifeExpectancy(lifeExpectancy);

                    cards.add(card);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return cards;
    }
}