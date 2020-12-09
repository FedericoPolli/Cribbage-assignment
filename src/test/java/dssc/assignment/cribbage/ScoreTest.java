package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void ParseScore() {
        CribbageScore score = new CribbageScore("ASKS2SJSAH");
        assertEquals(6, score.getScore());
    }
}
