package dssc.assignment.cribbage;

public class CribbageScoreCalculator {

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
        score += 2*hand.NumberOfPairs();
        score += hand.LengthOfRun();
        score += 2*hand.NumberOfFifteenTwos();
        return score;
    }

}
