package scalajavaexercises.javacode;


/*
* Given an array of integers, return a new array such that each element at index i of the new array is the product
* of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
* If our input was [3, 2, 1], the expected output would be [2, 3, 6]
* */

import java.util.Arrays;

public class ProductUp {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int total = Arrays.stream(numbers).reduce(1, (acc, x) -> acc * x);

        int[] copyNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copyNumbers[i] = total / numbers[i];
        }

        Arrays.stream(copyNumbers).forEach(System.out::println);
    }


}
