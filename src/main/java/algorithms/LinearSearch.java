package algorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(linearSearch(a, 12));
    }

    static int linearSearch(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) return i;
        }
        return -1;
    }

}
