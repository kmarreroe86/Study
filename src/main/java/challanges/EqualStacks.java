package challanges;

import java.util.Stack;

// https://www.hackerrank.com/challenges/equal-stacks/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class EqualStacks {

	public static void main(String[] args) {
		int[] h1 = new int[] { 3, 2, 1, 1, 1 };
		int[]h2 = new int[] { 4, 3, 2 };
		int[] h3 = new int[] { 1, 1, 4, 1 };
		int k = equalStacks(h1, h2, h3);
		System.out.println(k);

	}

	static int equalStacks(int[] h1, int[] h2, int[] h3) {

		Stack<Integer> h1Height = new Stack<Integer>();
		Stack<Integer> h2Height = new Stack<Integer>();
		Stack<Integer> h3Height = new Stack<Integer>();
		int totalHeight1 = 0;
		int totalHeight2 = 0;
		int totalHeight3 = 0;
		
		for (int i = h1.length - 1; i >= 0; i--) {
			totalHeight1 += h1[i];
			h1Height.add(totalHeight1);
		}

		for (int i = h2.length - 1; i >= 0; i--) {
			totalHeight2 += h2[i];
			h2Height.add(totalHeight2);
		}

		for (int i = h3.length - 1; i >= 0; i--) {
			totalHeight3 += h3[i];
			h3Height.add(totalHeight3);
		}

		while (true) {
			if (h1Height.isEmpty() || h2Height.isEmpty() || h3Height.isEmpty()) return 0;

			totalHeight1 = h1Height.peek();
			totalHeight2 = h2Height.peek();
			totalHeight3 = h3Height.peek();

			if (totalHeight1 == totalHeight2 && totalHeight2 == totalHeight3) {
				return totalHeight1;
			}

			if (totalHeight1 >= totalHeight2 && totalHeight1 >= totalHeight3)
				h1Height.pop();
			else if (totalHeight2 >= totalHeight1 && totalHeight2 >= totalHeight3)
				h2Height.pop();
			else if (totalHeight3 >= totalHeight1 && totalHeight3 >= totalHeight2) 
				h3Height.pop();
		}
	}

	static boolean check(int h1Height, int h2Height, int h3Height) {
		return h1Height == h2Height && h2Height == h3Height;
	}

}
