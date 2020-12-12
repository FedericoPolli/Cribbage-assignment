package dssc.assignment.cribbage;

import java.util.Locale;

public enum Suite {
    HEARTS, CLUBS, DIAMONDS, SPADES;

    public static Suite parseSuite(String charSuite) throws IllegalArgumentException {
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
