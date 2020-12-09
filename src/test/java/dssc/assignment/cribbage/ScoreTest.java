package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void HandExampleOne() {
        CribbageScore score = new CribbageScore("0DJHQSAC9D");
        assertEquals(4, score.getScore());
    }

    @Test
    void HandExampleTwo() {
        CribbageScore score = new CribbageScore("5H5D5SJC5C");
        assertEquals(29, score.getScore());
    }

    @Test
    void HandExampleThree() {
        CribbageScore score = new CribbageScore("JH2CAS0H9D");
        assertEquals(3, score.getScore());
    }

    @Test
    void HandExampleFour() {
        CribbageScore score = new CribbageScore("3S5CQHKH2D");
        assertEquals(8, score.getScore());
    }

    @Test
    void HandExampleFive() {
        CribbageScore score = new CribbageScore("0C0S3CKHKS");
        assertEquals(4, score.getScore());
    }

    @Test
    void HandExampleSix() {
        CribbageScore score = new CribbageScore("QCKH3S2D0C");
        assertEquals(6, score.getScore());
    }

    @Test
    void HandExampleSeven() {
        CribbageScore score = new CribbageScore("AS5D6D4D3D");
        assertEquals(8, score.getScore());
    }
}
