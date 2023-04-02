package scalaAndJavaExercices.javacode;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/the-hurdle-race/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class HurdleRace {

    public static void main(String[] args) {

        Integer[] bar = {2, 5, 4, 5, 2};
        List<Integer> s = Arrays.asList(bar);
        int k = 7;

        // Sort descending
        s.sort((o1, o2) -> {
            if (o1 < o2) return 1;
            else return -1;
        });

        System.out.println(s.get(0) > k ? s.get(0) - k : 0);
    }
}
