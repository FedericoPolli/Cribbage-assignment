package dssc.assignment.cribbage;

import java.util.*;
import java.util.stream.Collectors;

public class CribbageHand {
    private static final int TOTAL_NUMBER_OF_CARDS = 5;
    private static final int NUMBER_OF_CARDS_IN_HAND = 4;

    private final List<Card> hand = new ArrayList<>();

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
        Card starterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        List<Card> actualHand = hand.subList(0,NUMBER_OF_CARDS_IN_HAND);
        return actualHand.stream().filter(Card::IsJack).anyMatch(c -> c.HasSameSuitAs(starterCard));
    }

    public boolean HasFlush() {
        Card firstCard = hand.get(0);
        List<Card> actualHand = hand.subList(0,NUMBER_OF_CARDS_IN_HAND);
        return actualHand.stream().allMatch(c -> c.HasSameSuitAs(firstCard));
    }

    public boolean IsFirstCardSameSuitAsStarterCard() {
        Card FirstCard = hand.get(0);
        Card StarterCard = hand.get(TOTAL_NUMBER_OF_CARDS-1);
        return FirstCard.HasSameSuitAs(StarterCard);
    }

    public boolean AceIsPresent() {
        return hand.stream().anyMatch(Card::IsAce);
    }

    public boolean HasDouble() {
        return !(hand.stream().allMatch(new HashSet<>()::add));
    }

    public int NumberOfPairs() {
        int Pair_Number = 0;
        for (int cardIndex = 0; cardIndex < TOTAL_NUMBER_OF_CARDS-1; cardIndex++) {
            Pair_Number += CountNumberOfSameCards(cardIndex);
        }
        return Pair_Number;
    }

    private int CountNumberOfSameCards(int cardIndex) {
        Card CardOne = hand.get(cardIndex);
        return (int) hand.subList(cardIndex+1, TOTAL_NUMBER_OF_CARDS).stream().filter(card -> card.HasSameRankAs(CardOne)).count();
    }

    public int LengthOfRun() {
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
        for (int i = 0; i < TOTAL_NUMBER_OF_CARDS-2; i++) {
            int run = checkRun(i, handCopy);
            if (run >= 3) { return run; }
        }
        return 0;
    }

    private int checkRun(int i, List<Card> handCopy) {
        int run = 1;
        Card CardOne = handCopy.get(i);
        for (int j = i+1; j < TOTAL_NUMBER_OF_CARDS; j++) {
            Card CardTwo = handCopy.get(j);
            if (CardOne.getRankValue()+j-i == CardTwo.getRankValue()) {
                run++;
            }
            else { break; }
        }
        return run;
    }

    public int NumberOfFifteenTwos() {
        List<Integer> FifteenTwos = hand.stream().map(Card::valueFifteenTwos).collect(Collectors.toList());
        List<Integer> SubsetSums = Utilities.GenerateSubsetSums(FifteenTwos);
        return (int) SubsetSums.stream().filter(x -> x == 15).count();
    }
}
