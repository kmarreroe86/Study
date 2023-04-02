package sortalgorithms;

import java.util.Arrays;

public class CountingSort {

    public static void sort(int[] data) {
        int[] tmp = new int[11];

        for (int i = 0; i < data.length; i++) {
            tmp[data[i]] = tmp[data[i]] + 1;
        }

        int curr = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i]; j++) {
                data[curr] = i;
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 3, 10, 2, 4, 0, 9, 5, 7, 2, 8, 10, 3, 9 };
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}
