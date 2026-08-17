package lesson_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphUtil {

    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;

    public static int[][] matrixToList(int[][] matrix) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) continue;
                if (matrix[i][j] != 0) {
                    edges.add(new int[]{i, j});
                }
            }
        }
        int[][] edgeList = new int[edges.size()][2];
        int i = 0;
        for (int[] arr : edges) {
            edgeList[i] = arr;
            i++;
        }
        return edgeList;
    }

    public static int[] topologicalSort(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Некорректная матрица смежности");
        }

        int[] states = new int[matrix.length];
        List<Integer> nodes = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (states[i] == WHITE) {
                tarjanAlgorithm(i, matrix, states, nodes);
            }
        }

        return nodes.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void tarjanAlgorithm(int node, int[][] matrix,
                                        int[] states, List<Integer> nodes) {
        if (states[node] == BLACK) return;
        if (states[node] == GREY)
            throw new RuntimeException("Найден цикл, топологическая сортировка невозможна");

        states[node] = GREY;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1) { //связь между вершинами, а не статус вершины
                tarjanAlgorithm(i, matrix, states, nodes);
            }
        }

        states[node] = BLACK;
        nodes.addFirst(node);
    }
}
