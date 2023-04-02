package introductionexamples;

public class Examples {

	// Greatest common divisor
	public static int getGCD(int m, int n) {
		if (n > m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		int r = m % n;
		if (r == 0) {
			return n;
		}

		m = n;
		n = r;
		return getGCD(m, n);
	}

	public static void bubbleSortRecursive(int[] numbers, int sortedIndex) {
		if (sortedIndex == 0)
			return;

		for (int i = 0; i < sortedIndex - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				int tmp = numbers[i + 1];
				numbers[i + 1] = numbers[i];
				numbers[i] = tmp;
			}
		}

		bubbleSortRecursive(numbers, --sortedIndex);
	}

	public static void bubbleSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int tmp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = tmp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[index] > numbers[j]) {
					index = j;
				}
			}
			if (numbers[index] < numbers[i]) {
				int tmp = numbers[i];
				numbers[i] = numbers[index];
				numbers[index] = tmp;
			}
		}
	}
	
	public static void insertionSort(int[] numbers) {
		for (int i = 0; i < numbers.length -1; i++) {
			int current = numbers[i];
			int j = i - 1;
			while (j >= 0 && numbers[j] > current) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = current;
		}
	}

	public static void main(String[] args) {

		System.out.println("Greatest Common Divisor(4, 3)= " + getGCD(4, 3));

		System.out.println("Bubble Sort:");
		int[] bubbleSortArr = { 10, 2, 6, 7, 3, 8 };
//		bubbleSortRecursive(bubbleSortArr, bubbleSortArr.length);		
		bubbleSort(bubbleSortArr);
		printArray(bubbleSortArr);
		
		System.out.println("Selection Sort:");
		int[] selectionSortArr = { 10, 2, 6, 7, 3, 8 };
		selectionSort(selectionSortArr);
		printArray(selectionSortArr);
		
		System.out.println("Insertion Sort:");
		int[] insertionSortArr = { 10, 2, 6, 7, 3, 8 };
		selectionSort(insertionSortArr);
		printArray(insertionSortArr);
	}
	
	private static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
