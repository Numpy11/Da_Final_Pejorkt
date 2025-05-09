import java.util.Scanner;

public class Player {
    // Data Attributes
    private String name;
    private int balance;
    private Card[] holeCards = new Card[2];
    private boolean isInGame;
    private boolean isHuman;
    Scanner keyboard = new Scanner(System.in);

    // Constructors
   public Player() {

   }

    // Helpers

    public Player(boolean isHuman) { // i need to define whos human and not so that i dont show user NPC holecards & to automate betting
        this.isHuman = isHuman;
    }

        // I want to get user name & balance independently and then pass them into the game class
    public String userName() {
        System.out.println("Enter the Player's Name: ");
        String newGuy = keyboard.nextLine();
        return newGuy;
    }

    public int userBalance() {
        System.out.println("Enter the Player's Starting Chip Count: ");
        int newGuysChips = Integer.parseInt(keyboard.nextLine()); //1 am asked GPT cuz started adding this, n want in for pres.
        return newGuysChips;
    }

    public Card[] userCards() {
        Card[] hand = getHoleCards();
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
        return ("Player: " + this.name
                + " has a balance of " + this.balance
                + ". \nHole Cards: " + this.holeCards[0] + " " + this.holeCards[1]
                + "\n" + "In the game: " + this.isInGame);
    }

}
