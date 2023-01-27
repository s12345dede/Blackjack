package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    public static void main(String[] args){
        //result = "[Player X, Player Y]"
    }
    
    public static Integer calculateHandValue(Player player){
        List<Card> hand = player.getHand();
        int handValue = 0;
        int aceAmount = 0;
        for (Card card : hand) {
            handValue += card.getValue();
            if(card instanceof CardAce) aceAmount++;
        }
        while(handValue > 21 && aceAmount>0){
            handValue -= 10;
            aceAmount--;
        }
        
        return handValue;
    }
    
    public static boolean checkIfWinner(Player player1, Player player2){
        Integer value1 = calculateHandValue(player1);
        Integer value2 = calculateHandValue(player2);
        
        if(value2 > 21) return false;
        if(value1 == 21 && value2 == 21 && 
           player1.getHand().size() != 2 && 
           player2.getHand().size() == 2) return true;
        if(value1 >= value2) return false;
        else return true;
    }
    
    public static List<Player> getWinners(Player croupier, Player player1, Player player2, Player player3, Deck deck){
        List<Player> winners = new ArrayList<>();
        while(calculateHandValue(croupier) < 17) croupier.giveCard(deck.removeCard());
        
        if(checkIfWinner(croupier, player1)) winners.add(player1);
        if(checkIfWinner(croupier, player2)) winners.add(player2);
        if(checkIfWinner(croupier, player3)) winners.add(player3);
        
        return winners;
    }
    
}
