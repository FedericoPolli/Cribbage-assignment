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
            if (hand.IsFirstCardSameSuitAsStarterCard()) {
                score += 5;
            } else {
                score += 4;
            }
        }

        score += 2*hand.NumberOfPairs();

        return score;
    }
}

