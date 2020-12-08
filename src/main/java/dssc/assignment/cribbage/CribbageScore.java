package dssc.assignment.cribbage;

public class CribbageScore {
    private Hand hand;

    public CribbageScore(String HandAsText) {
        this.hand = new Hand(HandAsText);
    }

    public int getScore() {
        int score = 0;
        if (hand.IsJackSameSuitOfStarterCard()) {
            score += 1;
        }


        return score;
    }
}

