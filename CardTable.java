public class CardTable implements Table<Card, CardPlayer> {
    private CardSet[] places;
    private int current_place;

    public CardTable() {
        places = new CardSet[Table.NUMBER_OF_PLACES];
        for (int i = 0; i < places.length; i++) {
            places[i] = new CardSet();
        }
        current_place = 0;
    }

    @Override
    public int[] getPlaces() {
        int[] placeIdentifiers = new int[Table.NUMBER_OF_PLACES];
        for (int i = 0; i < places.length; i++) {
            Card topCard = places[i].getTopCard();
            placeIdentifiers[i] = (topCard != null) ? topCard.identifier : -1;
        }
        return placeIdentifiers;
    }

    @Override
    public void takeTurn(CardPlayer player) {
        // Step 1: Get the card played by the player
        Card playedCard = player.play();
        if (playedCard == null) {
            // No cards left to play, end the turn
            player.setTurn(false);
            return;
        }

        // Step 2: Add the card to the current place on the table
        places[current_place].addCard(playedCard);

        // Step 3: Check for matching ranks in other places
        for (int i = 0; i < places.length; i++) {
            if (i != current_place) { // Skip the current place
                Card topCard = places[i].getTopCard();
                if (topCard != null && topCard.getRank() == playedCard.getRank()) {
                    // Step 4: Match found! Add both cards to the player's bank and increment points
                    player.bank.addCard(topCard); // Add the matching card from the table
                    player.bank.addCard(playedCard); // Add the played card
                    player.setPoints(player.getPoints() + 1); // Increment points

                    // Remove the matching card from the table
                    places[i].removeTopCard();
                    break; // Only one match per turn
                }
            }
        }

        // Step 5: Update the current place to the next place
        current_place = (current_place + 1) % Table.NUMBER_OF_PLACES;

        // Step 6: Set the player's turn to false
        player.setTurn(false);
    }
}
