package scalaAndJavaExercices.javacode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place
 * */
public class LowestNonExistingPositive {

    public static void main(String[] args) {
        int[]numbers = {3, 4, -1, 1};
        int[]numbers2 = {1,2,0};
        int[]numbers3 = {-1,-2,0};
        int[]numbers4 = {1,2,3};

        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ": " +smallestMissingInt(numbers));
        System.out.println(Arrays.stream(numbers2).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ": " + smallestMissingInt(numbers2));
        System.out.println(Arrays.stream(numbers3).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ": " + smallestMissingInt(numbers3));
        System.out.println(Arrays.stream(numbers4).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ": " + smallestMissingInt(numbers4));
    }

    public static int smallestMissingInt(int[] numbers) {
        int smallestInt = 1;
        if (numbers.length == 0) return smallestInt;

        Arrays.sort(numbers);
        if (numbers[0] > 1) return smallestInt;
        if (numbers[numbers.length - 1] <= 0) return smallestInt;

        for (int number : numbers) {
            if (number == smallestInt) smallestInt++;
        }

        return smallestInt;
    }
}
