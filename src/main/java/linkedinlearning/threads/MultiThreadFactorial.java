package linkedinlearning.threads;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadFactorial {

    public static void main(String[] args) {
        var factorials = findAnswer(Arrays.asList(5,10,15,20,25,30));
        System.out.println(factorials);
    }

    static Map<Integer, BigInteger> findAnswer(List<Integer> numbers) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Map.Entry<Integer, BigInteger>>> futures = new ArrayList<>();
        for (Integer number : numbers) {
            futures.add(executor.submit(new FactorialTask(number)));
        }

        Map<Integer, BigInteger> results = new HashMap<>();
        for (Future<Map.Entry<Integer, BigInteger>> future : futures) {
            try {
                Map.Entry<Integer, BigInteger> result = future.get();
                results.put(result.getKey(), result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return results;
    }

    static class FactorialTask implements Callable<Map.Entry<Integer, BigInteger>> {
        private final Integer number;
        FactorialTask(Integer number) {
            this.number = number;
        }

        @Override
        public Map.Entry<Integer, BigInteger> call() throws Exception {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= number; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return new AbstractMap.SimpleEntry<>(number, factorial);
        }
    }
}
