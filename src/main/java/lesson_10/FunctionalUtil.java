package lesson_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalUtil {

    public static HashMap<Integer, List<String>> calculateNames(String textFilePath) throws IOException {
        try (Stream<String> stream = Files.lines(Path.of(textFilePath))) {
            return stream
                .parallel()
                .map(x -> x.toLowerCase().split(" "))
                .filter(x -> x.length == 2 && x[1].matches("\\d+"))
                .collect(Collectors.groupingBy(
                        x -> Integer.parseInt(x[1]),
                        HashMap::new,
                        Collectors.mapping(
                                y -> toTitleCase(y[0]),
                                Collectors.toCollection(ArrayList::new)
                        )
                ));
        }
    }

    private static String toTitleCase(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
