package dssc.assignment.cribbage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ScoreTest {

    @Test
    void RunOfFour() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("0DJHQSAC9D");
        assertEquals(4, score.getCribbageScore());
    }

    @Test
    void DoublePairRoyal_JackOfSameSuit_and_EightFifteenTwos() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("5H5D5SJC5C");
        assertEquals(29, score.getCribbageScore());
    }

    @Test
    void FlushInHand_and_RunOfFive() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("JHQH8H0H9D");
        assertEquals(9, score.getCribbageScore());
    }

    @Test
    void FourFifteenTwos() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("3S5CQHKH2D");
        assertEquals(8, score.getCribbageScore());
    }

    @Test
    void DoublePair() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("0C0S3CKHKS");
        assertEquals(4, score.getCribbageScore());
    }

    @Test
    void FullFlushWithJack_and_OneFifteenTwo() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("QC9C3CJC6C");
        assertEquals(8, score.getCribbageScore());
    }

    @Test
    void PairRoyal_and_RunOfThreeWithAceHigh() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("ASADAHQDKD");
        assertEquals(9, score.getCribbageScore());
    }

    @Test
    void NoPointsInHand() {
        CribbageScoreCalculator score = new CribbageScoreCalculator("0SJDAH2DKH");
        assertEquals(0, score.getCribbageScore());
    }

    @Test
    void IllegalNumberOfCards() {
        assertThrows(IllegalArgumentException.class, () -> new CribbageHand("ASADAHQDKDKH"));
    }

    @Test
    void HasSameCardTwice() {
        assertThrows(IllegalArgumentException.class, () -> new CribbageHand("ASADAHQDAS"));
    }
}
