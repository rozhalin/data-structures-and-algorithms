package lesson_11;

import java.util.List;

public class Magic {
    static void test(List<Integer> lst) {
        for (int i = 0; i < 3; i++) {
            lst.add(i - 17);
        }
    }

}
