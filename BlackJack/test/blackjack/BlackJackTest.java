package blackjack;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackJackTest {

    public BlackJackTest() {
    }

    @Test
    public void firstCase() {
        /*Player 1: "J", "A" (21, Black Jack)
        Player 2: "10", "5", "6" (21)
        Player 3: "3", "6", "A", "3", "A", "K" (24)
        Croupier: "9", "7" (16)
        Deck: "5", "4", "K", "2"
        
        getWinners(...) -----> [Player1]*/
        Player player1 = playerParser("Player 1", "J,A");
        Player player2 = playerParser("Player 2", "10,5,6");
        Player player3 = playerParser("Player 3", "3,6,A,3,A,K");
        Player croupier = playerParser("Croupier", "9,7");
        Deck deck = deckParser("5,4,K,2");
        List<Player> result = BlackJack.getWinners(croupier, player1, player2, player3, deck);

        assertEquals(result.toString(), "[Player 1]");
    }

    @Test
    public void secondCase() {
        /*Player 1: "10", "K" (20)
        Player 2: "10", "2", "6" (18)
        Player 3: "8", "8", "5" (21)
        Croupier: "5", "10" (15)
        Deck: "A" , "3" , "K" , "2"

        getWinners(...) -----> [Player1, Player3]*/

        Player player1 = playerParser("Player 1", "10,K");
        Player player2 = playerParser("Player 2", "10,2,6");
        Player player3 = playerParser("Player 3", "8,8,5");
        Player croupier = playerParser("Croupier", "5,10");
        Deck deck = deckParser("A,3,K,2");
        List<Player> result = BlackJack.getWinners(croupier, player1, player2, player3, deck);

        assertEquals(result.toString(), "[Player 1, Player 3]");
    }

    public Player playerParser(String name, String cards) {
        Player player = new Player(name);
        String[] split = cards.split(",");
        
        for (String string : split) {
            switch(string){
                case "1":
                case "2":    
                case "3":    
                case "4":    
                case "5":    
                case "6":    
                case "7":    
                case "8":    
                case "9":    
                case "10":
                    player.giveCard(new CardNumber(Integer.parseInt(string)));
                    break;
                case "J":
                case "Q":
                case "K":
                    player.giveCard(new CardKQJ(string));
                    break;
                case "A":
                    player.giveCard(new CardAce());
                    break;
            }
        }

        return player;
    }

    public Deck deckParser(String cards) {
        List<Card> cardList = new ArrayList<>();
        String[] split = cards.split(",");

        for (String string : split) {
            switch(string){
                case "1":
                case "2":    
                case "3":    
                case "4":    
                case "5":    
                case "6":    
                case "7":    
                case "8":    
                case "9":    
                case "10":
                    cardList.add(new CardNumber(Integer.parseInt(string)));
                    break;
                case "J":
                case "Q":
                case "K":
                    cardList.add(new CardKQJ("string"));
                    break;
                case "A":
                    cardList.add(new CardAce());
                    break;
            }
        }

        Deck deck = new Deck(cardList);
        return deck;
    }

}
