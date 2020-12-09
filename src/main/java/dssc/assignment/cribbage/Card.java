package dssc.assignment.cribbage;

public class Card {

    private Rank rank;
    private Suite suite;
    private int ValueForFifteenTwos;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;

        if (isAce()) {
            ValueForFifteenTwos = 1;
        }
        else if (IsPicture()) {
            ValueForFifteenTwos = 10;
        }
        else {
            ValueForFifteenTwos = rank.getValue();
        }
    }

    public boolean IsPicture() {
        return (rank.equals(Rank.JACK) || rank.equals(Rank.QUEEN) || rank.equals(Rank.KING));
    }

    public Rank getRank() { return rank; }

    public Suite getSuite() { return suite; }

    public int valueFifteenTwos() { return ValueForFifteenTwos; }

    public boolean isJack() {
        return (rank.equals(Rank.JACK));
    }

    public boolean isAce() {
        return (rank.equals(Rank.ACE));
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
        return (rank == c.getRank() && suite.equals(c.getSuite()));
    }
}
