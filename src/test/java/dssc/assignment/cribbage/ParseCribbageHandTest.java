package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParseCribbageHandTest {

    @Test
    void parseFiveOfHearts() {
        Card card = CardParser.parseCard("5H");
        assert card.equals(new Card(Rank.FIVE, Suite.HEARTS));
    }

    @Test
    void parseTwoOfSpades() {
        Card card = CardParser.parseCard("2S");
        assert card.equals(new Card(Rank.TWO, Suite.SPADES));
    }

    @Test
    void parseTenOfDiamondsInLowerCase() {
        Card card = CardParser.parseCard("0d");
        assert card.equals(new Card(Rank.TEN, Suite.DIAMONDS));
    }

    @Test
    void CheckIfAce() {
        Card card = new Card(Rank.ACE, Suite.HEARTS);
        assertTrue(card.IsAce());
    }

    @Test
    void CheckIfNotJack() {
        Card card = new Card(Rank.JACK, Suite.DIAMONDS);
        assertFalse(card.IsJack());
    }

    @Test
    void IllegalSuite() {
        assertThrows(IllegalArgumentException.class, () -> CardParser.parseCard("4R"));
    }

    @Test
    void IllegalRank() {
        assertThrows(IllegalArgumentException.class, () -> CardParser.parseCard("NC"));
    }

    @Test
    void IllegalLength() {
        assertThrows(IllegalArgumentException.class, () -> CardParser.parseCard("2CC"));
    }

}
