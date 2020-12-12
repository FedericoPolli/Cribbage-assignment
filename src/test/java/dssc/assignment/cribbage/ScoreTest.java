package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    void RunOfFour() {
        CribbageHand hand = new CribbageHand("0DJHQSAC9D");
        assertEquals(4, hand.getCribbageScore());
    }

    @Test
    void DoublePairRoyal_JackOfSameSuit_and_EightFifteenTwos() {
        CribbageHand hand = new CribbageHand("5H5D5SJC5C");
        assertEquals(29, hand.getCribbageScore());
    }

    @Test
    void FlushInHand_and_RunOfFive() {
        CribbageHand hand = new CribbageHand("JHQH8H0H9D");
        assertEquals(9, hand.getCribbageScore());
    }

    @Test
    void FourFifteenTwos() {
        CribbageHand hand = new CribbageHand("3S5CQHKH2D");
        assertEquals(8, hand.getCribbageScore());
    }

    @Test
    void DoublePair() {
        CribbageHand hand = new CribbageHand("0C0S3CKHKS");
        assertEquals(4, hand.getCribbageScore());
    }

    @Test
    void FullFlushWithJack_and_OneFifteenTwo() {
        CribbageHand hand = new CribbageHand("QC9C3CJC6C");
        assertEquals(8, hand.getCribbageScore());
    }

    @Test
    void PairRoyal_and_RunOfThreeWithAceHigh() {
        CribbageHand hand = new CribbageHand("ASADAHQDKD");
        assertEquals(9, hand.getCribbageScore());
    }

}
