package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseCribbageHandTest {

    @Test
    void parseFiveOfHearts() {
        Card card = CardParser.parseCard("5H");
        assertAll(
                () -> assertEquals(Rank.FIVE, card.getRank()),
                () -> assertEquals(Suite.HEARTS, card.getSuite()),
                () -> assertEquals(5, card.valueFifteenTwos())
        );
    }

    @Test
    void parseAceOfSpades() {
        Card card = CardParser.parseCard("AS");
        assertAll(
                () -> assertEquals(Rank.ACE, card.getRank()),
                () -> assertEquals(Suite.SPADES, card.getSuite()),
                () -> assertEquals(1, card.valueFifteenTwos()),
                () -> assertEquals(true, card.isAce())

        );
    }

    @Test
    void parseJackOfDiamonds() {
        Card card = CardParser.parseCard("jd");
        assertAll(
                () -> assertEquals(Rank.JACK, card.getRank()),
                () -> assertEquals(Suite.DIAMONDS, card.getSuite()),
                () -> assertEquals(10, card.valueFifteenTwos()),
                () -> assertEquals(true, card.isJack())

        );
    }


}
