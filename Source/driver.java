import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game poker = new Game();

        Random r = new Random();
        Card c1 = new Card(0, 11);
        Card c2 = new Card(1, 0);
        Deck d1 = new Deck();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(d1);
        // bringing the addplayer method to driver
        poker.addPlayer(scanner);
        // catching player list in box
        Player[] players = poker.getPlayerList();

        //catching # o' players in box
        int numPlayers = poker.getNumPlayers();
        // have to increment through each line in the list
        for (int i = 0; i < numPlayers; i++) {
            // for each
            System.out.println("Player: " + players[i].getName() + ", Balance: " + players[i].getBalance());
            // line in the list
            // printing name + balance
        }
        //Card[] holeCards = {new Card(1, 2), new Card(2, 3)};

    }
}
