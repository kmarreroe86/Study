package challanges;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class MinimumSwaps {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 4, 6, 7};
		

		var outOfPositions = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				outOfPositions++;
			}
		}

		System.out.println(outOfPositions - 1);
	}

}
