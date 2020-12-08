package dssc.assignment.cribbage;

public class Card {

    private Rank CardRank;
    private Suite CardSuite;
    private int ValueForFifteenTwos;

    public Card(Rank CardRank, Suite CardSuite) {
        this.CardRank = CardRank;
        this.CardSuite = CardSuite;

        if (CardIsAce()) {
            ValueForFifteenTwos = 1;
        }
        else if (CardIsPicture()) {
            ValueForFifteenTwos = 10;
        }
        else {
            ValueForFifteenTwos = CardRank.getValue();
        }
    }

    private boolean CardIsAce() {
        return CardRank.equals(Rank.ACE);
    }

    private boolean CardIsPicture() {
        return (CardRank.equals(Rank.JACK) || CardRank.equals(Rank.QUEEN) || CardRank.equals(Rank.KING));
    }

    public Rank rank() { return CardRank; }

    public Suite suite() { return CardSuite; }

    public int valueFifteenTwos() {return ValueForFifteenTwos;}

    public boolean isJack() {
        return (CardRank.equals(Rank.JACK));
    }
}
