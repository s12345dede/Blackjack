package blackjack;

import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
    
    public Card removeCard(){
        return cards.remove(0);
    }
    
}
