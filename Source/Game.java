import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // Data Attributes
    private Player[] playerList;
    private Deck gameDeck;
    private Card[] communityCards;
    private int winningPot;
    private int numPlayers;

    public final int MAX_PLAYERS = 25;

    // Constructors
    public Game() {
       // playerlist = new Player[0];
    }

    // Helpers
    public Card[] dealerDraw(Player[] playerList, Card[] holeCards, Card getNextCard) {
        for (int i = 0; i < playerList.length; i++) {
            // if less than 2 holeCards
            if(holeCards.length < 2) {
                // draw another and add it to index i
                holeCards[i] = getNextCard;
            }
        }
        return holeCards;
    }

    public static String input(String prompt, Scanner scanner){
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public static int input_int(String prompt, Scanner scanner){
        System.out.println(prompt + ": ");
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // I want to get user name & balance independently and then pass them into the game class
    public static String askUserName(Scanner scanner) {
        return input("Enter the Player's Name", scanner);
    }

    public static int askUserBalance(Scanner scanner) {
        return input_int("Enter the Player's Starting Chip Count", scanner);
    }


    public void addPlayer(Scanner scanner) {
        setNumPlayers(0);
        int numAdded = 0;
        playerList = new Player[MAX_PLAYERS];
        boolean addMore = true;

        while(numAdded < MAX_PLAYERS && addMore) {
            addMore = input("Would you like to add a player? y/n", scanner).equalsIgnoreCase("y");
            if (addMore) {
                // printing answer
                System.out.println();
                // asking for new name and balance
                // saving new name & balance
                Player newPlayer = new Player(
                    askUserName(scanner),
                    askUserBalance(scanner)
                );

                // adding the player to the list
                playerList[numAdded] = newPlayer;
                // incrementing the list so we dont overwrite the player
                numAdded++;
            }
        }
        setNumPlayers(numAdded);
    }

    // Getters

    public Player[] getPlayerList() {
        return playerList;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public Card[] getCommunityCards() {
        return communityCards;
    }
    public int getWinningPot() {
        return winningPot;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    // Setters
    public void setPlayerList(Player[] playerList ) {
        this.playerList = playerList;
    }

    public void setGameDeck(Deck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public void setCommunityCards(Card[] communityCards) {
        this.communityCards = communityCards;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}
