package blackjack;

public class CardKQJ implements Card{
    private final Integer value = 10;
    private final String letter;

    public CardKQJ(String letter) {
        this.letter = letter;
    }
    
    public Integer getValue(){
        return value;
    }
    
}
