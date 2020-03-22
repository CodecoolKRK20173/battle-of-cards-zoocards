package com.kuk.apps;

import java.util.Iterator;

class Card implements Comparable<Card> {

    Integer speed;
    Integer height;
    Integer strenght;
    Integer lifeExpectancy;
    String name;
    int whooseCardIsThisNow;
    int featureToCompare;
    

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWooseCardIsThisNow() {

        return this.whooseCardIsThisNow;
    }

    public void setWooseCardIsThisNow(int PlayerID) {

        this.whooseCardIsThisNow = PlayerID;
    }

    @Override
    public int compareTo(Card otherCard) {
        

        switch (featureToCompare) {
            case 1:
            featureToCompare = this.speed.compareTo(otherCard.getSpeed());
            case 2:
            featureToCompare = this.height.compareTo(otherCard.getHeight());
            case 3:
            featureToCompare = this.strenght.compareTo(otherCard.getStrenght());
            case 4:
            featureToCompare = this.lifeExpectancy.compareTo(otherCard.getLifeExpectancy());

        }
        return featureToCompare;
    }

    public String toString() {
        return "Card name: " + name + " | speed: " + speed + " | height: " + height + " | strength: " + strenght
                + " | lifeExpectancy: " + lifeExpectancy;

    }

}