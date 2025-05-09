import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game poker = new Game();
        System.out.println(poker.getGameDeck());

        Random r = new Random();
        // Card c1 = new Card(0, 11);
        // Card c2 = new Card(1, 0);
        // System.out.println(c1.getEnglish());
        // System.out.println(c2.getEnglish());
        // bringing the addplayer method to driver
        poker.askPlayers(scanner);
        // catching player list in box
        Player[] players = poker.getPlayerList();

        for (Player player : players) {
            System.out.println("Player: " + player.getName() + ", Balance: " + player.getBalance());
            // line in the list
            // printing name + balance
        }
        //Card[] holeCards = {new Card(1, 2), new Card(2, 3)};

    }
}
