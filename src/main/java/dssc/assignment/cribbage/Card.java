package dssc.assignment.cribbage;

public class Card {

    private Rank CardRank;
    private Suite CardSuite;
    private int ValueForFifteenTwos;

    public Card(Rank CardRank, Suite CardSuite) {
        this.CardRank = CardRank;
        this.CardSuite = CardSuite;

        if (isAce()) {
            ValueForFifteenTwos = 1;
        }
        else if (IsPicture()) {
            ValueForFifteenTwos = 10;
        }
        else {
            ValueForFifteenTwos = CardRank.getValue();
        }
    }

    private boolean IsPicture() {
        return (CardRank.equals(Rank.JACK) || CardRank.equals(Rank.QUEEN) || CardRank.equals(Rank.KING));
    }

    public Rank rank() { return CardRank; }

    public Suite suite() { return CardSuite; }

    public int valueFifteenTwos() {return ValueForFifteenTwos;}

    public boolean isJack() {
        return (CardRank.equals(Rank.JACK));
    }

    public boolean isAce() {
        return (CardRank.equals(Rank.ACE));
    }
}
