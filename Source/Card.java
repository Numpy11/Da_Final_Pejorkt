import java.util.Random;


public class Card {
    private int suit;
    private int value;

    // constructors
    public Card() {
        this.setSuit(-1);
        this.setValue(-1);
    }

    public Card(int suit, int value) {
        this.setSuit(suit);
        this.setValue(value);
    }

    // helpers


    public String getEnglish() {
        // suit 0-3
        // value 1-10: number cards; Ace-0
        //value 11-13: face cards; jack, queen, king
        if (this.getValue() == -1 || this.getSuit() == -1) {
            return "Invalid card"; // setting error values so that if it messes up it says this instead of wonky card name
        }
        // defining # & face cards with output 2
        String output2 = "";
        if (this.getValue() == 11) {
            output2 += "Jack";
        } else if (this.getValue() == 12) {
            output2 += "Queen";
        } else if (this.getValue() == 13) {
            output2 += "King";
        } else if (this.getValue() == 0) {
            output2 += "Ace";
        } else {
            output2 += "" + (this.getValue() + 1);
        }
        // defining suits
        String output3 = "";
        if (this.getSuit() == 0) {
            output3 += " of Clubs";
        } else if (this.getSuit() == 1) {
            output3 += " of Spades";
        } else if (this.getSuit() == 2) {
            output3 += " of Diamonds";
        } else if (this.getSuit() == 3) {
            output3 += " of Hearts";
        }
        // returning card # & suit
        return output2 + output3;
    }
        // commented out for debugging
//    public int makeCard() {
//        Random  nextCard= new Random();
//        int r1 = nextCard.nextInt(0, 13);
//        return r1;
//    }

    // getters
    public int getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }


    // setters
    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // toString
    public String toString() {
        String output = "Card: "
                + this.getEnglish();
        return output;
    }
}
