package lesson_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubsequenceTest {

    @Test
    void getLongestCommonSubsequenceTest() {
        String first = "ABDEFADRFG";
        String second = "DAFERG";
        String[] expected = { "DAFG", "AFRG", "AERG", "DFRG", "DERG", "DARG" };

        String[] actual = Subsequence.getLongestCommonSubsequence(first, second);
        assertArrayEquals(expected, actual);
    }
}
