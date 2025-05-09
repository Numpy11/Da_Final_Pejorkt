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
    Scanner keyboard = new Scanner(System.in);

    // Constructors
    public Game() {

    }
//        playerlist = new Player[0];

    // Helpers
    public Card[] dealerDraw(Player[] playerList, Card[] holeCards, Card getNextCard) {
        for (int i = 0; i < playerList.length; i++) {
            if(holeCards.length < 2) { // if less than 2 holeCards
                holeCards[i] = getNextCard; // draw another and add it to index i
            }
        }
        return holeCards;
    }

    public void init() {

    }


    public void addPlayer() {
        numPlayers = 0;
        int numAdded = 0;
        playerList = new Player[25];
        boolean addMore = true;
        while(numAdded < 25 && addMore) {
            System.out.println("Would you like to add a player? y/n: ");
            String more = keyboard.nextLine(); // saving answer
            if (more.equalsIgnoreCase("y")) {
                System.out.println(); // printing answer
                Player newPlayer = new Player();
                String name = newPlayer.userName(); // asking for new name and balance
                int balance = newPlayer.userBalance();
                newPlayer.setName(name); // saving new name & balance
                newPlayer.setBalance(balance);
                playerList[numAdded] = newPlayer; // adding the player to the list
                numAdded++; // incrementing the list so we dont overwrite the player
            } else if (more.equalsIgnoreCase("n")) {
                addMore = false;
            }
        }
        numPlayers = numAdded;
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

    // toString
    public String toString() {
        return ("");
    }
}
