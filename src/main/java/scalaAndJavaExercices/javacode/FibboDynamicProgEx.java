package scalaAndJavaExercices.javacode;

public class FibboDynamicProgEx {

    public static void main(String[] args) {
        int nthFibonacci = 50;
        long[]cache = new long[nthFibonacci + 1];
        long result = fibonacci(nthFibonacci, cache);
        System.out.println(result);
    }

    /**
     * Memoization - Top Down approach
     * */
    static long fibonacci(int n, long[]cache) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        if(cache[n] > 0) return cache[n];

        return cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
    }

    /**
     * Tabulation - Bottom Up approach
     * */
    static long fibo(int n) {
        long[] results = new long[n + 1];
        results[0] = 0;
        results[1] = 1;

        for (int i = 2; i <= n; i ++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }
}
