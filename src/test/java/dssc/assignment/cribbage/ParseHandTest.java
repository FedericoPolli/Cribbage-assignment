package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {

    @Test
    void parseFiveOfHearts() {
        Card card = CardParser.parseCard("5H");
        assertAll(
                () -> assertEquals(Rank.FIVE, card.rank()),
                () -> assertEquals(Suite.HEARTS, card.suite()),
                () -> assertEquals(5, card.valueFifteenTwos())
        );
    }

    @Test
    void parseAceOfSpades() {
        Card card = CardParser.parseCard("AS");
        assertAll(
                () -> assertEquals(Rank.ACE, card.rank()),
                () -> assertEquals(Suite.SPADES, card.suite()),
                () -> assertEquals(1, card.valueFifteenTwos()),
                () -> assertEquals(true, card.isAce())

        );
    }

    @Test
    void parseJackOfDiamonds() {
        Card card = CardParser.parseCard("JD");
        assertAll(
                () -> assertEquals(Rank.JACK, card.rank()),
                () -> assertEquals(Suite.DIAMONDS, card.suite()),
                () -> assertEquals(10, card.valueFifteenTwos()),
                () -> assertEquals(true, card.isJack())

        );
    }

}
