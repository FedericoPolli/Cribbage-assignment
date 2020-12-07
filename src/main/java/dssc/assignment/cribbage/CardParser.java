package dssc.assignment.cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        String CharSuite = cardAsText.substring(1);
        String CharRank = cardAsText.substring(0, 1);

        switch (CharSuite) {
            case "C":
                return new Card(CharRank, Suite.CLUBS);
            case "D":
                return new Card(CharRank, Suite.DIAMONDS);
            case "H":
                return new Card(CharRank, Suite.HEARTS);
            case "S":
                return new Card(CharRank, Suite.SPADES);
            default:
                System.out.println("Unknown card suite ");
                return null;
        }

    }
}
