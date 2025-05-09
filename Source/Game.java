import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // Data Attributes
    private Player[] playerList;
    private Deck gameDeck;
    private Card[] communityCards;
    private int winningPot;

    // Constructors
    public Game() {
        this.setPlayerList(new Player[0]);
        this.setGameDeck(new Deck());
        this.setCommunityCards(new Card[0]);
        this.setWinningPot(0);
    }

    // Helpers
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

    public static Player[] askPlayers(Scanner scanner) {
        int numAdded = 0;
        DynamicArray<Player> playerList = new DynamicArray<>(Player.class);

        while (true) {
            if (input("Would you like to add a player? y/n", scanner).equalsIgnoreCase("y")) {
                // asking for new name and balance
                Player newPlayer = new Player(
                    askUserName(scanner),
                    askUserBalance(scanner)
                );

                // adding the player to the list
                playerList.append(newPlayer);
            } else {
                break;
            }
        }
        return playerList.get_raw();
    }

    public void initPlayer(Scanner scanner){
        this.setPlayerList(this.askPlayers(scanner));
    }

    public Player[] getActivePlayerList() {
        Player[] players = this.getPlayerList();
        DynamicArray<Player> array = new DynamicArray<>(Player.class, players.length);
        for (Player player : players){
            if (!player.getFolded()){
                array.append(player);
            }
        }
        return array.get_raw();
    }

    public Card[] dealerDraw(Player[] playerList, Card[] holeCards, Card getNextCard) {
        for (int i = 0; i < playerList.length; i++) {
            // if less than 2 holeCards
            if (holeCards.length < 2) {
                // draw another and add it to index i
                holeCards[i] = getNextCard;
            }
        }
        return holeCards;
    }

    // Getters
    public Player[] getPlayerList() {
        return this.playerList;
    }

    public Deck getGameDeck() {
        return this.gameDeck;
    }

    public Card[] getCommunityCards() {
        return this.communityCards;
    }

    public int getWinningPot() {
        return this.winningPot;
    }

    // Setters
    public void setPlayerList(Player[] playerList) {
        this.playerList = playerList;
    }

    public void setGameDeck(Deck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public void setCommunityCards(Card[] communityCards) {
        this.communityCards = communityCards;
    }

    public void setWinningPot(int value){
        this.winningPot = value;
    }

    public static void print(String[] sequence){
        System.out.print("[");
        for (int i=0; i<sequence.length; i++){
            System.out.printf("\"%s\"", sequence[i]);
            if (i < sequence.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
