package puzzles.code;

import puzzles.tests.ReverseTest;

public class Reverse {

    /**
     * You are given an integer as an input. Write a program to return the reverse of a number.
     * <p>
     * returnReverse(23) → 32
     * returnReverse(45) → 54
     */

    public int returnReverse(int n) {

        // Solution 1
        // StringBuilder sbStr = new StringBuilder(String.valueOf(n));
        // return Integer.parseInt(sbStr.reverse().toString());


        // Solution 2
        // int iter = n;
//        StringBuilder nStr = new StringBuilder();
//        while (iter > 0) {
//            int rest = iter % 10;
//            nStr.append(rest);
//            iter = iter / 10;
//        }
//        return Integer.parseInt(nStr.toString());

        int remainder, sum = 0;
        while (n > 0) {
            remainder = n % 10;
            sum = sum * 10 + remainder;
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        ReverseTest.checkOutput();
    }
}
