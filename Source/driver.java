import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        // System.out.println(game.getGameDeck());

        Random r = new Random();
        // Card c1 = new Card(0, 11);
        // Card c2 = new Card(1, 0);
        // System.out.println(c1.getEnglish());
        // System.out.println(c2.getEnglish());
        // bringing the addplayer method to driver
        game.initPlayer(scanner);
        // catching player list in box
        Player[] players = game.getPlayerList();

        for (Player player : players) {
            // printing name + balance
            System.out.println("Player: " + player.getName() + ", Balance: " + player.getBalance());
        }
        //Card[] holeCards = {new Card(1, 2), new Card(2, 3)};

        for (Player player : game.getActivePlayerList()){
            game.dealCard(player);
        }
    }
}
