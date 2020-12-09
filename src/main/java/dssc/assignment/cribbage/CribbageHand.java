package dssc.assignment.cribbage;

import java.util.*;
import java.util.stream.Collectors;

public class CribbageHand {
    private static final int TOTAL_NUMBER_OF_CARDS = 5;
    private static final int NUMBER_OF_CARDS_IN_HAND = 4;

    private List<Card> hand = new ArrayList<>();

    public CribbageHand(String HandAsText) {
        String cards;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            cards = HandAsText.substring(2*i, 2*i+2);
            hand.add(CardParser.parseCard(cards));
        }
    }

    private boolean HasJackOfSameSuitAsStarterCard() {
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


    private boolean HasFlush() {
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

    private boolean IsFirstCardSameSuitAsStarterCard() {
        Card FirstCard = hand.get(0);
        Card StarterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        return (FirstCard.getSuite().equals(StarterCard.getSuite()));
    }

    private int NumberOfPairs() {
        Card CardOne;
        Card CardTwo;
        int Pair_Number = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            CardOne = hand.get(i);
            for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++ ) {
                CardTwo = hand.get(j);
                if (CardOne.getRank().equals(CardTwo.getRank())) {
                    Pair_Number++;
                }
            }
        }
        return Pair_Number;
    }

    private int LengthOfRun() {
        List<Card> handCopy = hand.stream().sorted(Comparator.comparing(Card::getRank)).collect(Collectors.toList());
        int LenOfRun = NormalRuns(handCopy);
        if (AceIsPresent()) {
            LenOfRun = Math.max(RunsWithAceHigh(handCopy), LenOfRun);
        }
        return LenOfRun;
    }

    private int RunsWithAceHigh(List<Card> handCopy) {
        Card AceHigh = new Card(Rank.ACE_HIGH, handCopy.get(0).getSuite());
        handCopy.remove(0);
        handCopy.add(AceHigh);
        return NormalRuns(handCopy);
    }

    private int NormalRuns(List<Card> handCopy) {
        Card CardOne;
        Card CardTwo;
        int run;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-2; i++) {
            run = 1;
            CardOne = handCopy.get(i);
            for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++) {
                CardTwo = handCopy.get(j);
                if (CardOne.getRank().getValue()+j-i == CardTwo.getRank().getValue()) {
                    run++;
                }
                else { break; }
            }
            if (run >= 3) { return run; }
        }
        return 0;
    }

    private boolean AceIsPresent() {
        Card currentCard;
        for (int i=0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            currentCard = hand.get(i);
            if (currentCard.isAce()) {
                return true;
            }
        }
        return false;
    }

    private int NumberOfFifteenTwos() {
        Card CurrentCard;
        List<Integer> FifteenTwos = new ArrayList<>();
        List<Integer> SubsetSums;
        int result = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            CurrentCard = hand.get(i);
            FifteenTwos.add(CurrentCard.valueFifteenTwos());
        }
        SubsetSums = Utilities.GenerateSubsetSums(FifteenTwos);
        for (int x : SubsetSums) {
            if (x == 15) {
                result++;
            }
        }
        return result;
    }

    public int getCribbageScore() {
        int score = 0;
        if (HasJackOfSameSuitAsStarterCard()) {
            score += 1;
        }
        if (HasFlush()) {
            score += 4;
            if (IsFirstCardSameSuitAsStarterCard()) {
                score += 1;
            }
        }
        score += 2*NumberOfPairs();
        score += LengthOfRun();
        score += 2*NumberOfFifteenTwos();
        return score;
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
