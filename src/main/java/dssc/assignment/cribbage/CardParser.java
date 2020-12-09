package dssc.assignment.cribbage;

import java.util.Locale;

public class CardParser {
    public static Card parseCard(String cardAsText) throws IllegalArgumentException {
        if (cardAsText.length() != 2) {
            throw new IllegalArgumentException("The argument passed does not represent a card. ");
        }
        String CharSuite = cardAsText.substring(1);
        String CharRank = cardAsText.substring(0, 1);
        return new Card(parseRank(CharRank), parseSuite(CharSuite));
    }

    private static Rank parseRank(String charRank) throws IllegalArgumentException {
        String UppercharRank = charRank.toUpperCase(Locale.ITALIAN);
        return switch (UppercharRank) {
            case "A" -> Rank.ACE;
            case "2" -> Rank.TWO;
            case "3" -> Rank.THREE;
            case "4" -> Rank.FOUR;
            case "5" -> Rank.FIVE;
            case "6" -> Rank.SIX;
            case "7" -> Rank.SEVEN;
            case "8" -> Rank.EIGHT;
            case "9" -> Rank.NINE;
            case "0" -> Rank.TEN;
            case "J" -> Rank.JACK;
            case "Q" -> Rank.QUEEN;
            case "K" -> Rank.KING;
            default -> throw new IllegalArgumentException("Unknown card rank: " + charRank);
        };
    }

    private static Suite parseSuite(String charSuite) throws IllegalArgumentException {
        String UppercharSuite = charSuite.toUpperCase(Locale.ITALIAN);
        return switch (UppercharSuite) {
            case "C" -> Suite.CLUBS;
            case "D" -> Suite.DIAMONDS;
            case "H" -> Suite.HEARTS;
            case "S" -> Suite.SPADES;
            default -> throw new IllegalArgumentException("Unknown card suite " + charSuite);
        };
    }
}
