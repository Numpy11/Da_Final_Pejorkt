import java.util.Scanner;

public class Player {
    // Data Attributes
    private String name;
    private int balance;
    private DynamicArray<Card> hand;
    private boolean folded;

    // Constructors
    public Player(String name, int balance){
        this.setName(name);
        this.setBalance(balance);
        this.setHand(new DynamicArray<>(Card.class));
        this.setFolded(false);
    }

    // Helpers
    public void addToBalance(int value) {
        int balance = this.getBalance();
        balance += value;
        this.setBalance(balance);
    }

    public void reduceFromBalance(int value) {
        this.addToBalance(-value)
    }

    public void holdCard(Card card){
        this.getHand().append(card);
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public DynamicArray<Card> getHand() {
        return this.hand;
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

    public void setHand(DynamicArray<Card> hand) {
        this.hand = hand;
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
            + ". \nHand: " + this.hand[0] + " " + this.hand[1]
            + "\n" + "In the game: " + this.folded
        );
    }
}
