package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void ParseScore() {
        Hand hand = new Hand("AS4H8DKHJS");
        assertEquals(0, hand.getscore());
    }
}
