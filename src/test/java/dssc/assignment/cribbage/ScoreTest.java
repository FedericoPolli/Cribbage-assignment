package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void HandExampleOne() {
        CribbageScore score = new CribbageScore("0DJHQSAC9D");
        assertEquals(4, score.getScore());
    }
}
