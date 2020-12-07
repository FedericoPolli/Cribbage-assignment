package dssc.assignment.cribbage;

public class Card {

    private String cardrank;
    private Suite cardsuite;

    public Card(String cardrank, Suite cardsuite) {
        this.cardrank = cardrank;
        this.cardsuite = cardsuite;
    }

    public String rank() {
        return cardrank;
    }

    public Suite suite() {
        return cardsuite;
    }
}
