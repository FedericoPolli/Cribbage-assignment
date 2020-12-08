package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<>();

    public Hand(String HandAsText) {
        String cards;
        for (int i = 0; i < 5; i++) {
            cards = HandAsText.substring(2*i, 2*i+2);
            hand.add(CardParser.parseCard(cards));
        }
    }
    
    public Card GetLastCard() {
        return hand.get(4);
    }

    public boolean IsJackSameSuitOfStarterCard() {
        Card currentCard;
        Card starterCard = hand.get(4);
        for (int i = 0; i < 4; i++) {
            currentCard = hand.get(i);
            if (currentCard.isJack()) {
               if (currentCard.suite().equals(starterCard.suite()))  {
                   return true;
               }
            }
        }
        return false;
    }


    public boolean IsFlushInHand() {
        Card currentCard;
        Card followingCard;
        for (int i = 0; i < 3; i++) {
            currentCard = hand.get(i);
            followingCard = hand.get(i+1);
            if (! currentCard.suite().equals(followingCard.suite())) {
                return false;
            }
        }
        return true;
    }

    public boolean IsFirstCardSameSuitAsStarterCard() {
        Card FirstCard = hand.get(0);
        Card StarterCard = hand.get(4);
        return (FirstCard.suite().equals(StarterCard.suite()));
    }
}
