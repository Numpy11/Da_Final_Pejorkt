import java.util.ArrayList;

public class Deck {
    // Data Attributes
    private final int SUITS = 4;
    private final int CARDS_PER_SUIT = 13;

    // list o' cards with our # o' cards
    private DynamicArray<Card> cards;

    // Constructors
    public Deck() {
        this.reset_unshuffled();
        this.shuffle_cards();
    }

    public Deck(int numDecks, int topIndex) {
        this.reset_unshuffled();
        this.shuffle_cards();
    }

    // Helpers
    public void reset_unshuffled() {
        // System.out.println("making decks!"); //test
        int tempIndex = 0; // starting count @ 0
        // making a 2d list of cards that is # o' decks * # o' cards
        DynamicArray<Card> cards = new DynamicArray<>(Card.class, this.SUITS * this.CARDS_PER_SUIT);
        // incrementing through # o' suits
        for (int suit = 0; suit < this.SUITS; suit++) {
            // incrementing through all cards in each suit
            for (int value = 0; value < this.CARDS_PER_SUIT; value++) {
                // making a new card list *ing numDecks and CARDS
                cards.append(new Card(suit, value));
            }
        }
        // setting out list o' deck
        this.setCards(cards);
    }

    private static int random_int(int min, int max){
        return min + (int)(Math.random() * (max - min + 1));
    }

    public static DynamicArray<Card> shuffle_card_array(DynamicArray<Card> cards) {
        int count = cards.get_size();
        Card[] temp = new Card[count];
        for (int i=0; i<count; i++){
            temp[i] = cards.pop(random_int(0, cards.get_size()-1));
        }
        return new DynamicArray<>(temp);
    }

    public void shuffle_cards(){
        this.setCards(this.shuffle_card_array(this.getCards()));
    }

    public Card drawCard() {
        try {
            return this.getCards().pop();
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    // Getters
    public DynamicArray<Card> getCards() {
        return this.cards;
    }

    // Setters

    public void setCards(DynamicArray<Card> cards) {
        this.cards = cards;
    }

    // toStrings

    public String toString() {
        String card_repr = "[";
        int i = 0;
        int count = this.getCards().get_size() - 1;
        for (Card card : this.getCards()){
            card_repr += card;
            if (i < count){
                card_repr += ", ";
            }
            i++;
        }
        card_repr += "]";

        return super.toString() + card_repr;
    }
}
