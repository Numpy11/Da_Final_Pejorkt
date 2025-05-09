import java.util.ArrayList;

public class Deck {
    // Data Attributes
    private Card[] cards; // list o' cards with our # o' cards
    private int numDecks; // D.A. for # decks
    private final int CARDS = 52; // global variable to set number o' cards in decks
    private int topIndex; // the card we will be drawing

    // Constructors
    public Deck() {
        this.setTopIndex(0); // pulling top card
        this.setNumDecks(2); // setting # o' decks to 2
        this.init(); // running init
    }

    public Deck(int numDecks, int topIndex) {
        this.setTopIndex(topIndex);
        this.setNumDecks(numDecks);
        this.init();
    }

    // Helpers
    public void init() {
        System.out.println("making decks!"); //test
        int numSuits = 4;
        int numVals = 13;
        int tempIndex = 0; // starting count @ 0
        // making a 2d list of cards that is # o' decks * # o' cards
        Card[] temp = new Card[this.getNumDecks() * this.CARDS];
        // incrementing through # o' decks
        for (int i = 0; i < this.getNumDecks(); i++) {
            // incrementing through # o' suits
            for (int k = 0; k < numSuits; k++) {
                // incrementing through all cards in each suit
                for (int l = 0; l < numVals; l++) {
                    // making a new card list *ing numDecks and CARDS
                    temp[tempIndex] = new Card(k, l);
                    // then incrementing it to make another deck
                    tempIndex++;
                }
            }
        }
        // setting out list o' deck
        this.setCards(temp);
    }

    public Card getNextCard() {
        Card hand = null;
        try {
            hand = this.getCards()[this.getTopIndex()];
            this.setTopIndex(this.getTopIndex()+1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Empty Deck");
        }
        return hand;
    }

    // Getters
    public Card[] getCards() {
        return this.cards;
    }

    public int getNumDecks() {
        return this.numDecks;
    }
    public int getTopIndex() {
        return this.topIndex;
    }

    // Setters

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void setNumDecks(int numDecks) {
        this.numDecks = numDecks;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    // toStrings

    public String toString() {
        return "";
    }
}
