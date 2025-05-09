import java.util.Arrays;
import java.util.Random;

public class driver {
    public static void main(String[] args) {
        Game poker = new Game();

        Random r = new Random();
        Card c1 = new Card(0, 11);
        Card c2 = new Card(1, 0);
        Deck d1 = new Deck();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(d1);
        poker.addPlayer(); // bringing the addplayer method to driver
        Player[] players = poker.getPlayerList(); // catching player list in box

        int numPlayers = poker.getNumPlayers();; //catching # o' players in box
        for (int i = 0; i < numPlayers; i++) { // have to increment through each line in the list
            System.out.println("Player: " + players[i].getName() + ", Balance: " + players[i].getBalance()); // for each
            // line in the list
            // printing name + balance
        }
        //Card[] holeCards = {new Card(1, 2), new Card(2, 3)};

    }
}
