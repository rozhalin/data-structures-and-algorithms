package lesson_10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalUtilTest {

    @Test
    void calculateNamesTest() throws IOException {
        String textFilePath = "src/main/resources/lesson_10/task.txt";

        HashMap<Integer, List<String>> expected = new HashMap<>();
        expected.put(5, List.of("Вася", "Аня"));
        expected.put(3, List.of("Петя"));

        HashMap<Integer, List<String>> actual = FunctionalUtil.calculateNames(textFilePath);

        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }
}
