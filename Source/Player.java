import java.util.Scanner;

public class Player {
    // Data Attributes
    private String name;
    private int balance;
    private Card[] holeCards;
    private boolean folded;

    // Constructors
    public Player(String name, int balance){
        this.setName(name);
        this.setBalance(balance);
        this.setHoleCards(new Card[2]);
        this.setFolded(false);
    }

    // Helpers
    public void addToBalance(int value) {
        int balance = this.getBalance();
        balance += value;
        this.setBalance(balance);
    }

    public void reduceFromBalance(int value) {
        this.addToBalance(-value);
    }

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

    public boolean getFolded() {
        return this.folded;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setHoleCards(Card[] holeCards) {
        this.holeCards = holeCards;
    }

    public void setFolded(boolean folded) {
        this.folded = folded;
    }

    // toString
    public String toString() {
        return (
            super.toString()
            + this.name
            + " has a balance of " + this.balance
            + ". \nHole Cards: " + this.holeCards[0] + " " + this.holeCards[1]
            + "\n" + "In the game: " + this.folded
        );
    }
}
