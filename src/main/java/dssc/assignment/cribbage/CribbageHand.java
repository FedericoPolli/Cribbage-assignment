package dssc.assignment.cribbage;

import java.util.*;

public class CribbageHand {
    private static final int TOTAL_NUMBER_OF_CARDS = 5;
    private static final int NUMBER_OF_CARDS_IN_HAND = 4;

    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand() {
        return hand;
    }

    public CribbageHand(String HandAsText) throws IllegalArgumentException {
        if (HandAsText.length() != TOTAL_NUMBER_OF_CARDS*2) {
            throw new IllegalArgumentException("Wrong number of cards");
        }
        String cards;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            cards = HandAsText.substring(2*i, 2*i+2);
            hand.add(CardParser.parseCard(cards));
        }
        if (this.HasDouble()) {
            throw new IllegalArgumentException("The same card was provided twice.");
        }
    }

    public boolean HasJackOfSameSuitAsStarterCard() {
        Card currentCard;
        Card starterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            currentCard = hand.get(i);
            if (currentCard.isJack()) {
               if (currentCard.getSuite().equals(starterCard.getSuite()))  {
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
            if (! currentCard.getSuite().equals(followingCard.getSuite())) {
                return false;
            }
        }
        return true;
    }

    public boolean IsFirstCardSameSuitAsStarterCard() {
        Card FirstCard = hand.get(0);
        Card StarterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        return (FirstCard.getSuite().equals(StarterCard.getSuite()));
    }

    public boolean AceIsPresent() {
        Card currentCard;
        for (int i=0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            currentCard = hand.get(i);
            if (currentCard.isAce()) {
                return true;
            }
        }
        return false;
    }

    public int getCribbageScore() {
        CribbageScoreCalculator Score = new CribbageScoreCalculator(this);
        return Score.getCribbageScore();
    }

    public boolean HasDouble() {
        Card CardOne;
        Card CardTwo;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            CardOne = hand.get(i);
            for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++ ) {
                CardTwo = hand.get(j);
                if (CardOne.equals(CardTwo)) {
                    return true;
                }
            }
        }
        return false;
    }

}
