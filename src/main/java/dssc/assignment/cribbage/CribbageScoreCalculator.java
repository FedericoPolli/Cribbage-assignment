package dssc.assignment.cribbage;

public class CribbageScoreCalculator {

    private CribbageHand hand;

    public CribbageScoreCalculator(CribbageHand hand) {
        this.hand = hand;
    }

    public CribbageScoreCalculator(String handAsText) {
        this.hand = new CribbageHand(handAsText);
    }

    public int getCribbageScore() {
        int score = 0;
        score += FifteenTwosScore();
        score += RunsScore();
        score += PairsScore();
        score += FlushScore();
        return score;
    }

    private int FlushScore() {
        int flushScore = 0;
        if (hand.HasJackOfSameSuitAsStarterCard()) {
            flushScore += 1;
        }
        if (hand.HasFlush()) {
            flushScore += 4;
            if (hand.IsFirstCardSameSuitAsStarterCard()) {
                flushScore += 1;
            }
        }
        return flushScore;
    }

    private int PairsScore() {
        return 2*hand.NumberOfPairs();
    }

    private int RunsScore() {
        return hand.LengthOfRun();
    }

    private int FifteenTwosScore() {
        return 2*hand.NumberOfFifteenTwos();
    }

}
