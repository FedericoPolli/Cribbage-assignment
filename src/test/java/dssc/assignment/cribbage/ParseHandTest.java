package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseHandTest {

    @Test
    void parseFiveOfHearts() {
        Card card = CardParser.parseCard("5H");
        assertAll(
                () -> assertEquals("5", card.rank()),
                () -> assertEquals(Suite.HEARTS, card.suite()),
                () -> assertEquals(5, card.value())
        );
    }

    @Test
    void parseAceOfSpades() {
        Card card = CardParser.parseCard("AS");
        assertAll(
                () -> assertEquals("A", card.rank()),
                () -> assertEquals(Suite.SPADES, card.suite()),
                () -> assertEquals(1, card.value())

        );
    }

}
