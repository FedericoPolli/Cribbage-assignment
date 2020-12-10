package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CribbageScoreCalculator {

    private static final int TOTAL_NUMBER_OF_CARDS = CribbageHand.getTotalNumberOfCards();
    private CribbageHand hand;

    public CribbageScoreCalculator(CribbageHand hand) {
        this.hand = hand;
    }

    public int getCribbageScore() {
        int score = 0;
        if (hand.HasJackOfSameSuitAsStarterCard()) {
            score += 1;
        }
        if (hand.HasFlush()) {
            score += 4;
            if (hand.IsFirstCardSameSuitAsStarterCard()) {
                score += 1;
            }
        }
        score += 2*NumberOfPairs();
        score += LengthOfRun();
        score += 2*NumberOfFifteenTwos();
        return score;
    }

    private int NumberOfPairs() {
        Card CardOne;
        Card CardTwo;
        int Pair_Number = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-1; i++) {
            CardOne = hand.getHand().get(i);
            for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++ ) {
                CardTwo = hand.getHand().get(j);
                if (CardOne.getRank().equals(CardTwo.getRank())) {
                    Pair_Number++;
                }
            }
        }
        return Pair_Number;
    }

    private int LengthOfRun() {
        List<Card> handCopy = hand.getHand().stream().sorted(Comparator.comparing(Card::getRank)).collect(Collectors.toList());
        int LenOfRun = NormalRuns(handCopy);
        if (hand.AceIsPresent()) {
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

    private int NumberOfFifteenTwos() {
        Card CurrentCard;
        List<Integer> FifteenTwos = new ArrayList<>();
        List<Integer> SubsetSums;
        int result = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS; i++) {
            CurrentCard = hand.getHand().get(i);
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

}
