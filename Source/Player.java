import java.util.Scanner;

public class Player {
    // Data Attributes
    private String name;
    private int balance;
    private Card[] holeCards;
    private boolean isInGame;
    private boolean isHuman;

    // Constructors
    // public Player() {
    //     holeCards = new Card[2];
    // }

    // public Player(boolean isHuman) {
    //     // I need to define who's human and not so that I don't show user NPC
    //     // holecards & to automate betting
    //     this.isHuman = isHuman;
    // }

    public Player(String name, int balance){
        this.setName(name);
        this.setBalance(balance);
    }

    // Helpers
    public Card[] userCards() {
        Card[] hand = getHoleCards();
        return hand;
    }


    // Getters
    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public Card[] getHoleCards() {
        return this.holeCards;
    }

    public boolean getIsInGame() {
        return this.isInGame;
    }

    public boolean getIsHuman() {
        return this.isHuman;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addToBalance(int additionAmount) {
        this.balance += additionAmount;
    }

    public void reduceFromBalance(int reduceAmount) {
        this.balance -= reduceAmount;
    }

    public void setHoleCards(Card[] holeCards) {
        this.holeCards = holeCards;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    // toString
    public String toString() {
        return (
            super.toString()
            + this.name
            + " has a balance of " + this.balance
            + ". \nHole Cards: " + this.holeCards[0] + " " + this.holeCards[1]
            + "\n" + "In the game: " + this.isInGame
        );
    }

}
