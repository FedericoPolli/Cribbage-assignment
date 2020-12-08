package dssc.assignment.cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        String CharSuite = cardAsText.substring(1);
        String CharRank = cardAsText.substring(0, 1);
        return new Card(parseRank(CharRank), parseSuite(CharSuite));
    }

    private static Rank parseRank(String charRank) {
        switch (charRank) {
            case "A":
                return Rank.ACE;
            case "2":
                return Rank.TWO;
            case "3":
                return Rank.THREE;
            case "4":
                return Rank.FOUR;
            case "5":
                return Rank.FIVE;
            case "6":
                return Rank.SIX;
            case "7":
                return Rank.SEVEN;
            case "8":
                return Rank.EIGHT;
            case "9":
                return Rank.NINE;
            case "0":
                return Rank.TEN;
            case "J":
                return Rank.JACK;
            case "Q":
                return Rank.QUEEN;
            case "K":
                return Rank.KING;
            default:
                System.out.println("Unknown card rank ");
                return null;
        }
    }

    private static Suite parseSuite(String charSuite) {
        switch (charSuite) {
            case "C":
                return Suite.CLUBS;
            case "D":
                return Suite.DIAMONDS;
            case "H":
                return Suite.HEARTS;
            case "S":
                return Suite.SPADES;
            default:
                System.out.println("Unknown card suite ");
                return null;
        }
    }
}
