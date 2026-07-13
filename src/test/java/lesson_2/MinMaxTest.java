package lesson_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MinMaxTest {

    @Test
    public void mainTest() {
        List<Integer> lst = List.of(0, 10, -3, 5, 6, -4, 12, 159, -2, 1, 38);
        Result res = Solution.findMinMax(lst);
        Assertions.assertEquals(-4, res.min());
        Assertions.assertEquals(159, res.max());
        System.out.printf("MIN: %d, MAX: %d", res.min(), res.max());
    }
}
