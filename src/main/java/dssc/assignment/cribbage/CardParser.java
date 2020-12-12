package dssc.assignment.cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) throws IllegalArgumentException {
        if (cardAsText.length() != 2) {
            throw new IllegalArgumentException("The argument passed does not represent a card. ");
        }
        String CharSuite = cardAsText.substring(1);
        String CharRank = cardAsText.substring(0, 1);
        return new Card(Rank.parseRank(CharRank), Suite.parseSuite(CharSuite));
    }

}
