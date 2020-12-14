package dssc.assignment.cribbage;

import java.util.Locale;

public enum Suite {
    HEARTS(1), DIAMONDS(2), CLUBS(3),  SPADES(4);

    private final int value;

    Suite(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

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
