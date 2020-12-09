package dssc.assignment.cribbage;

public class CribbageScore {
    private Hand hand;

    public CribbageScore(String HandAsText) {
        this.hand = new Hand(HandAsText);
    }

    public int getScore() {
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

        return score;
    }
}

