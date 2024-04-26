package hackerrank;


import java.math.BigDecimal;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/fibonacci-modified/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class FibonacciModified {

    public static void main(String[] args) {
//        System.out.println(fibonacciModified(0, 1,6));
//        System.out.println(fibonacciModified(0, 1,5));
        System.out.println(fibonacciModified(0, 1,10));
    }

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static int fibonacciModified(int t1, int t2, int n) {
        BigDecimal[] result = new BigDecimal[n + 1];
        result[0] = new BigDecimal(String.valueOf(t1));
        result[1] = new BigDecimal(String.valueOf(t2));

        for(int i = 2; i < n; i++) {
            result[i] = result[i - 2].add(result[i - 1].pow(2));
        }

        return result[n - 1].intValue();
    }
}

/*
*  static long fibo(int n) {
        long[] results = new long[n + 1];
        results[0] = 0;
        results[1] = 1;

        for (int i = 2; i <= n; i ++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }
    * */
