public class CardPlayer extends GeneralPlayer<Card> {
    private int points;
    private boolean turn;
    private CardSet hand;
    public CardSet bank; // Public as per the assignment

    public CardPlayer(String name) {
        super(name);
        this.points = 0;
        this.turn = false;
        this.hand = new CardSet();
        this.bank = new CardSet();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public CardSet getHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.addCard(card);
    }

    public String handToString() {
        return name + "'s hand (" + hand.getNumCards() + " cards): " + hand.setToString();
    }

    public String bankToString() {
        return name + "'s bank (" + bank.getNumCards() + " cards): " + bank.setToString();
    }

    @Override
    public Card play() {
        if (hand.getNumCards() == 0) {
            return null; // No cards left to play
        }
        return hand.removeTopCard();
    }
}
