package lesson_7;

import java.util.*;
import java.util.stream.Collectors;

public class Subsequence {

    public static String[] getLongestCommonSubsequence(String first, String second) {
        HashMap<String, HashSet<String>> memo = new HashMap<>();
        HashSet<String> result = getLCS(memo, first, second);
        int maxLength = result.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();


        String[] array = result.stream()
                .filter(s -> s.length() == maxLength)
                .toArray(String[]::new);

        System.out.printf("input: %s, %s; output: %s", first, second, Arrays.toString(array));
        return array;
    }

    private static HashSet<String> getLCS(HashMap<String, HashSet<String>> memo, String a, String b) {
        System.out.printf("input: %s, %s %n", a, b);
        if (a.isEmpty() || b.isEmpty()) {
            return new HashSet<>();
        }

        String joint = String.join(";", a, b);

        if (memo.containsKey(joint)) {
            return memo.get(joint);
        }

        char lastA = a.charAt(a.length() - 1);
        char lastB = b.charAt(b.length() - 1);

        String newA = a.substring(0, a.length() - 1);
        String newB = b.substring(0, b.length() - 1);

        if (lastA == lastB) {
            HashSet<String> subsequences = getLCS(memo, newA, newB);
            if (subsequences.isEmpty()) {
                return new HashSet<>(List.of(String.valueOf(lastA)));
            } else {
                HashSet<String> result = subsequences
                        .stream().map(x -> x + lastA)
                        .collect(Collectors.toCollection(HashSet::new));
                System.out.println("output: " + result);
                memo.put(String.join(";", newA, newB), result);
                return result;
            }
        } else {
            HashSet<String> resultA = getLCS(memo, newA, b);
            HashSet<String> resultB = getLCS(memo, a, newB);
            memo.put(String.join(";", newA, b), resultA);
            memo.put(String.join(";", a, newB), resultB);
            resultA.addAll(resultB);
            System.out.println("output: " + resultA);
            return resultA;
        }
    }
}
