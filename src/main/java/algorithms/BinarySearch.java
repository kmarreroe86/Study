package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
        System.out.println(binarySearch(a, 111));
        System.out.println("Rec: " + binarySearchRec(a, 44, 0, a.length - 1));
    }

    static int binarySearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (list[pivot] == target) return pivot;
            else if (list[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }

    static int binarySearchRec(int[] list, int target, int left, int right) {
        if(list.length == 0 || left > right) return -1;
//        if (left > right) return -1;

        int pivot = left + (right - left) / 2;
        if (list[pivot] == target) return pivot;
        else if (list[pivot] < target) return binarySearchRec(list, target, pivot + 1, right);
        return binarySearchRec(list, target, left, pivot - 1);
    }
}

// https://youtu.be/8hly31xKli0?t=7065