package dp;

import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=ewXklhesC-w&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=2&ab_channel=JAVAAID-CodingInterviewPreparation
public class Fibonacci {

    public static void main(String[] args) {

    }


    /**
     * Top-Down, memoization relies on recursion
     *  time complexity: O(n)
     * space complexity: O(n)
     */

    static int fibTopDown(int n) {
        int[] cache = new int[n + 1];
        if (n < 2) return n;

        if (cache[n] != 0) { // if cache[n] is defined
            return cache[n];
        }

        return cache[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
    }

    /**
     * Bottom-Up tabulation, avoids recursion
     *  time complexity: O(n)
     * space complexity: O(n)
     */
    static int fibBottomUp(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    /**Efficient solution
     * time complexity: O(n)
     * space complexity: O(1)
     * */
    static int fib(int n) {
        int first = 0;
        int second = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }
}
