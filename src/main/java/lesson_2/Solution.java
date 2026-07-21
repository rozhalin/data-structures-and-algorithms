package lesson_2;

import java.util.List;

public class Solution {

    public static Result findMinMax(List<Integer> lst) {
        if (lst == null || lst.isEmpty())
            throw new IllegalArgumentException("Пустой список");
        if (lst.size() == 1)
            return new Result(lst.getFirst(), lst.getFirst());

        int min;
        int max;
        int i = 0;

        if (lst.size() % 2 != 0) {
            min = lst.get(0);
            max = lst.get(0);
            i = 1;
        } else {
            if (lst.get(0) > lst.get(1)) {
                min = lst.get(1);
                max = lst.get(0);
            } else {
                min = lst.get(0);
                max = lst.get(1);
                i = 2;
            }
        }

        int a;
        int b;

        for (; i < lst.size(); i += 2) {
            a = lst.get(i);
            b = lst.get(i + 1);

            int tempMin;
            int tempMax;

            if (a > b) {
                tempMax = a;
                tempMin = b;
            } else {
                tempMax = b;
                tempMin = a;
            }
            if (tempMax > max) {
                max = tempMax;
            }
            if (tempMin < min) {
                min = tempMin;
            }
        }

        return new Result(min, max);
    }
}
