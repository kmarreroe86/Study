package hackerrank;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/sansa-and-xor/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class SansaAndXor {

    public static void main(String[] args) {
//        int v1 = 4 ^ 5;
//        int v2 = v1 ^ 7;
//        int v3 = v2 ^ 5;
//        System.out.println(v3);
//        System.out.println(4 ^ 5 ^ 7 ^ 5);
        System.out.println(sansaXor(Arrays.asList(1,2,3)));
    }

    public static int sansaXor(List<Integer> arr) {
        Integer[] numbers = arr.toArray(new Integer[0]);

        int a = 0;
        if (numbers.length % 2 == 0) {
            return 0;
        }
        for (int x = 0; x < numbers.length; x += 2) {
            a = a ^ numbers[x];
        }
        return a;
    }
}
