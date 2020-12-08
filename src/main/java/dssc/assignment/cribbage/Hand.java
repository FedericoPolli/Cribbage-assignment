package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<>();
    private int score;

    public Hand(String HandAsText) {
        for (int i = 0; i < 5; i++) {
            String cards = HandAsText.substring(2*i, 2*i+2);
            hand.add(CardParser.parseCard(cards));
        }
    }

    public Card GetLastCard() {
        return hand.get(4);
    }

    public int getscore() {
        return score;
    }
}
