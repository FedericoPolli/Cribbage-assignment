package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand {
    private static final int TOTAL_NUMBER_OF_CARDS = 5;
    private static final int NUMBER_OF_CARDS_IN_HAND = 4;

    private List<Card> hand = new ArrayList<>();

    public Hand(String HandAsText) {
        String cards;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            cards = HandAsText.substring(2*i, 2*i+2);
            hand.add(CardParser.parseCard(cards));
        }
    }
    
    public Card GetLastCard() {
        return hand.get(4);
    }

    public boolean HasJackOfSameSuitAsStarterCard() {
        Card currentCard;
        Card starterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            currentCard = hand.get(i);
            if (currentCard.isJack()) {
               if (currentCard.suite().equals(starterCard.suite()))  {
                   return true;
               }
            }
        }
        return false;
    }


    public boolean HasFlush() {
        Card currentCard;
        Card followingCard;
        for (int i = 0; i < NUMBER_OF_CARDS_IN_HAND-1; i++) {
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
        Card StarterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        return (FirstCard.suite().equals(StarterCard.suite()));
    }

    public int NumberOfPairs() {
        Card CardOne;
        Card CardTwo;
        int Pair_Number = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            CardOne = hand.get(i);
            for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++ ) {
                CardTwo = hand.get(j);
                if (CardOne.rank().equals(CardTwo.rank())) {
                    Pair_Number++;
                }
            }
        }
        return Pair_Number;
    }

}
