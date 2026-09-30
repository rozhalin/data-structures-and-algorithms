package lesson_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalUtil {

    public static HashMap<Integer, List<String>> calculateNames(String textFilePath) {
        try (Stream<String> stream = Files.lines(Path.of(textFilePath))) {
            return stream
                .map(String::toLowerCase)
                    .filter(x -> {
                            String[] array = x.split(" ");
                            if (array.length != 2) {
                                return false;
                            }
                            try {
                                Integer.parseInt(array[1]);
                                return true;
                            } catch (NumberFormatException e) {
                                return false;
                            }
                        }
                    )
                    .collect(
                        Collectors.groupingBy(x ->
                            Integer.parseInt(x.split(" ")[1]),
                            HashMap::new,
                            Collectors.mapping(x ->
                                {
                                    String name = x.split(" ")[0];
                                    return name.substring(0, 1).toUpperCase() + name.substring(1);
                                },
                                Collectors.toCollection(ArrayList::new)
                            )
                        )
                    );
        } catch (IOException e) {
            return null;
        }
    }
}
