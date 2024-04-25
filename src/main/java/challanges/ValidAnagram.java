package challanges;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {

        var isAnagramCounting = isAnagramCountingApproach("car", "rat"); // "anagram", "nagaram"
        System.out.println(isAnagramCounting);

        var isAnagramSorting = isAnagramSortingAproach("anagram", "nagaram");
        System.out.println(isAnagramSorting);
    }

    // aproach #1 sorting
    public static boolean isAnagramSortingAproach(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        var s1Sorted = s1.chars()
                .sorted()
                .toArray();

        var s2Sorted = s2.chars()
                .sorted()
                .toArray();
        
        return Arrays.equals(s1Sorted, s2Sorted);
    }



    // approach #2 counting
    public static boolean isAnagramCountingApproach(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        Map<Character, Long> s1Counts = s1.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(
                        Function.identity(), // Group by character
                        Collectors.counting() // Count occurrences
                ));

        Map<Character, Long> s2Counts = s2.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(
                        Function.identity(), // Group by character
                        Collectors.counting() // Count occurrences
                ));

        boolean isEqual = s1Counts.entrySet().stream()
                .allMatch(entry -> s2Counts.getOrDefault(entry.getKey(), 0L).equals(entry.getValue()));

        return isEqual;
    }
}
