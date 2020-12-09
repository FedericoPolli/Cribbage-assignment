package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void HandExampleOne() {
        CribbageHand hand = new CribbageHand("0DJHQSAC9D");
        assertEquals(4, hand.getCribbageScore());
    }

    @Test
    void HandExampleTwo() {
        CribbageHand hand = new CribbageHand("5H5D5SJC5C");
        assertEquals(29, hand.getCribbageScore());
    }

    @Test
    void HandExampleThree() {
        CribbageHand hand = new CribbageHand("JH2CAS0H9D");
        assertEquals(3, hand.getCribbageScore());
    }

    @Test
    void HandExampleFour() {
        CribbageHand hand = new CribbageHand("3S5CQHKH2D");
        assertEquals(8, hand.getCribbageScore());
    }

    @Test
    void HandExampleFive() {
        CribbageHand hand = new CribbageHand("0C0S3CKHKS");
        assertEquals(4, hand.getCribbageScore());
    }

    @Test
    void HandExampleSix() {
        CribbageHand hand = new CribbageHand("QCKH3S2D0C");
        assertEquals(6, hand.getCribbageScore());
    }

    @Test
    void HandExampleSeven() {
        CribbageHand hand = new CribbageHand("AS5D6D4D3D");
        assertEquals(8, hand.getCribbageScore());
    }

}
