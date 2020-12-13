package dssc.assignment.cribbage;

import java.util.Locale;

public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE_HIGH(14);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rank parseRank(String charRank) throws IllegalArgumentException {
        String UppercharRank = charRank.toUpperCase(Locale.ITALIAN);
        return switch (UppercharRank) {
            case "A" -> ACE;
            case "2" -> TWO;
            case "3" -> THREE;
            case "4" -> FOUR;
            case "5" -> FIVE;
            case "6" -> SIX;
            case "7" -> SEVEN;
            case "8" -> EIGHT;
            case "9" -> NINE;
            case "0" -> TEN;
            case "J" -> JACK;
            case "Q" -> QUEEN;
            case "K" -> KING;
            default -> throw new IllegalArgumentException("Unknown card rank: " + charRank);
        };
    }
}
