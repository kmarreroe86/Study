package scalaAndJavaExercices.javacode;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/the-birthday-bar/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
public class SubArrayDivision {

    public static void main(String[] args) {

        Integer[] bar = {2,2,1,3,2};
        List<Integer> s = Arrays.asList(bar);
        int d = 4; // total sum
        int m = 2; // length
        int waysCanBeDivided = 0;
        int size = s.size();

        for (int i = 0; i <= size - m; i++) {
            int tmpSum = 0;
            int counter = 0;
            while(counter < m) {
                tmpSum += s.get(i + counter);
                counter ++;
            }
            if (tmpSum == d) waysCanBeDivided++;
        }

        System.out.println(waysCanBeDivided);
    }
}
