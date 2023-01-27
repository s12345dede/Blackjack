package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> hand;
    private final String name;

    public Player(String name) {
        hand = new ArrayList<>();
        this.name = name;
    }
    
    public void giveCard(Card card){
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }
    
    public String toString(){
        return name;
    }
    
}
