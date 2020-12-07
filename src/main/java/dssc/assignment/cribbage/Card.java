package dssc.assignment.cribbage;

public class Card {

    private String CardRank;
    private Suite CardSuite;

    public Card(String CardRank, Suite CardSuite) {
        this.CardRank = CardRank;
        this.CardSuite = CardSuite;
    }

    public String rank() {
        return CardRank;
    }

    public Suite suite() {
        return CardSuite;
    }
}
