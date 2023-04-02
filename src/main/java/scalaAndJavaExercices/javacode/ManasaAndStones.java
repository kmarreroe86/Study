package scalaAndJavaExercices.javacode;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/manasa-and-stones/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=60-day-campaign
public class ManasaAndStones {

    public static void main(String[] args) {
        int n = 3;// input = 4 || input - 1;
        int a = 10;
        int b = 100;

        List<Integer> kaka = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            kaka.add((n - i) * a + i * b );
        }

        System.out.println(kaka);
        /*int[][] table = new int[n - 1][(n - 1) * 2];
        int step = 1;
        for (int i = 0; i < table.length; i++) {
            int number = a;
             for(int j = 0; j < (n - 1) * 2; j++) {
                 if (j<= step) {
                     table[j][i] = number;
                 } else {
                     number = b;
                 }
             }
        }*/
    }
}
