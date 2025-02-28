public class CardPlayer extends GeneralPlayer<Card> {
    private int points; // Tracks the player's score
    private boolean turn; // Indicates if it's the player's turn
    private CardSet hand; // Stores the player's hand of cards
    public CardSet bank; // Public as per the assignment, stores won cards

    // Default constructor: Initializes a player with default name, no points, and empty hand/bank
    public CardPlayer() {
        super("Default Player");
        this.points = 0;
        this.turn = false;
        this.hand = new CardSet();
        this.bank = new CardSet();
    }

    // Parameterized constructor: Initializes a player with a given name, no points, and empty hand/bank
    public CardPlayer(String name) {
        super(name);
        this.points = 0;
        this.turn = false;
        this.hand = new CardSet();
        this.bank = new CardSet();
    }

    // Returns the player's current points
    public int getPoints() {
        return points;
    }

    // Sets the player's points to the given value
    public void setPoints(int points) {
        this.points = points;
    }

    // Returns true if it's the player's turn
    public boolean isTurn() {
        return turn;
    }

    // Sets the player's turn to the given boolean value
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    // Returns the player's hand of cards
    public CardSet getHand() {
        return hand;
    }

    // Adds a card to the player's hand
    public void addToHand(Card card) {
        hand.addCard(card);
    }

    // Returns a string representation of the player's hand
    public String handToString() {
        return name + "'s hand (" + hand.getNumCards() + " cards): " + hand.setToString();
    }

    // Returns a string representation of the player's bank
    public String bankToString() {
        return name + "'s bank (" + bank.getNumCards() + " cards): " + bank.setToString();
    }

    // Plays the top card from the player's hand and returns it
    @Override
    public Card play() {
        if (hand.getNumCards() == 0) {
            return null; // No cards left to play
        }
        return hand.removeTopCard();
    }
}
