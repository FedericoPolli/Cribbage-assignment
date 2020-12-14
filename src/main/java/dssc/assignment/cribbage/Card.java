package dssc.assignment.cribbage;

public class Card {

    private final Rank rank;
    private final Suite suite;
    private final int ValueForFifteenTwos;
    private final int rankValue;
    private final int suiteValue;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;

        if (IsAce()) {
            ValueForFifteenTwos = 1;
        }
        else if (IsPicture()) {
            ValueForFifteenTwos = 10;
        }
        else {
            ValueForFifteenTwos = rank.getValue();
        }

        rankValue = rank.getValue();
        suiteValue = suite.getValue();
    }

    public boolean IsPicture() {
        return (rank.equals(Rank.JACK) || rank.equals(Rank.QUEEN) || rank.equals(Rank.KING));
    }

    public Rank getRank() { return rank; }

    public Suite getSuite() { return suite; }

    public int valueFifteenTwos() { return ValueForFifteenTwos; }

    public boolean IsJack() {
        return (rank.equals(Rank.JACK));
    }

    public boolean IsAce() {
        return (rank.equals(Rank.ACE));
    }

    public boolean HasSameSuitAs(Card otherCard) {
        return (suite.equals(otherCard.getSuite()));
    }

    public boolean HasSameRankAs(Card otherCard) {
        return (rank.equals(otherCard.getRank()));
    }

    public int getRankValue() {
        return rankValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card c = (Card) o;
        return (rank.equals(c.getRank()) && suite.equals(c.getSuite()));
    }

    @Override
    public int hashCode() {
        return 17 * rankValue + 31 * suiteValue;
    }
}
