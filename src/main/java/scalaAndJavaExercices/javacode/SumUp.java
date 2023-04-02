package scalaAndJavaExercices.javacode;

import java.util.HashSet;

public class SumUp {

    /*
    * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    */
    public static void main(String[] args) {
        int[] numbers = new int[]{10, 15, 3, 7};
        int number = 17;

        System.out.println(sumUp(numbers, number));
    }

    public static boolean sumUp(int[] numbers, int number) {

        HashSet<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(numbers[0]);
        for(int i = 1; i <numbers.length; i++) {
            if (uniqueNumbers.contains(number - numbers[i])) return true;
            uniqueNumbers.add(numbers[i]);
        }

        return false;
    }
}
