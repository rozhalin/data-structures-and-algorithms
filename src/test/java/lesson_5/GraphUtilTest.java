package lesson_5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GraphUtilTest {

    @Test
    public void matrixToListTest() {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{0, 1, 1, 0};
        matrix[1] = new int[]{1, 0, 1, 1};
        matrix[2] = new int[]{1, 1, 0, 0};
        matrix[3] = new int[]{0, 0, 0, 0};

        int[][] result = new int[7][2];
        result[0] = new int[]{0, 1};
        result[1] = new int[]{0, 2};
        result[2] = new int[]{1, 0};
        result[3] = new int[]{1, 2};
        result[4] = new int[]{1, 3};
        result[5] = new int[]{2, 0};
        result[6] = new int[]{2, 1};

        assertArrayEquals(result, GraphUtil.matrixToList(matrix));
    }

    @Test
    public void topologicalSortTest() {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{0, 1, 0, 0};
        matrix[1] = new int[]{0, 0, 1, 0};
        matrix[2] = new int[]{0, 0, 0, 1};
        matrix[3] = new int[]{0, 0, 0, 0};

        System.out.println("matrix: " + Arrays.deepToString(matrix));

        int[] expected = new int[] { 0, 1, 2, 3 };
        System.out.println("expected: " + Arrays.toString(expected));

        int[] result = GraphUtil.topologicalSort(matrix);
        System.out.println("result: " + Arrays.toString(result));

        assertArrayEquals(expected, result);
    }
}
