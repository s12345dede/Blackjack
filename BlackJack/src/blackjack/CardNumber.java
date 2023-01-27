package blackjack;

public class CardNumber implements Card{
    private final Integer value;

    public CardNumber(Integer value) {
        this.value = value;
    }
    
    public Integer getValue(){
        return value;
    }
    
}
