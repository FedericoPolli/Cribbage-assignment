package dssc.assignment.cribbage;

import java.util.Locale;

public enum Suite {
    HEARTS, CLUBS, DIAMONDS, SPADES;

    public static Suite parseSuite(String charSuite) throws IllegalArgumentException {
        String UppercharSuite = charSuite.toUpperCase(Locale.ITALIAN);
        return switch (UppercharSuite) {
            case "C" -> CLUBS;
            case "D" -> DIAMONDS;
            case "H" -> HEARTS;
            case "S" -> SPADES;
            default -> throw new IllegalArgumentException("Unknown card suite " + charSuite);
        };
    }
}
