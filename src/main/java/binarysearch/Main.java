package binarysearch;

public class Main {

	public static void main(String[] args) {
		int[] numbers = { -3, -2, -1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15 };
		int target = 15;
//		System.out.println("secuencialBinarySearch at index: " + secuencialBinarySearch(target, numbers));
//		System.out.println("recursiveBinarySearch at index: " + recursiveBinarySearch(target, 0, numbers.length - 1, numbers));
		
		System.out.format("recursiveBinarySearch for %d at index: %d%n", target, sequentialBinarySearch(target, numbers));
		System.out.format("recursiveBinarySearch for %d at index: %d%n", target, recursiveBinarySearch(target, 0, numbers.length - 1, numbers)); 
	}

	public static int recursiveBinarySearch(int target, int left, int right, int[] numbers) {

		if (left > right)
			return -1;
		int pivot = left + ((right - left) / 2);

		if (target == numbers[pivot]) {
			return pivot;
		}

		if (target > numbers[pivot]) {
			left = pivot + 1;
		} else if (target < numbers[pivot]) {
			right = pivot - 1;
		}
		return recursiveBinarySearch(target, left, right, numbers);
	}

	public static int sequentialBinarySearch(int target, int[] numbers) {

		int left = 0, right = numbers.length - 1;
		while (left <= right) {
			
			int pivot = left + ((right - left) / 2);
			if (numbers[pivot] == target)
				return pivot;
			if (target > numbers[pivot]) {
				left = pivot + 1;
			} else {
				if (target < numbers[pivot]) {
					right = pivot - 1;
				}
			}
		}

		return -1;
	}

}
