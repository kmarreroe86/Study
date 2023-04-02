package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class AdmiosTest {

	public static void t(Object o) {
		System.out.println("kaka");
	}

	public static void t(String o) {
		System.out.println("kaka2");
	}

	/*
	 * public static void t(Integer o) { System.out.println("kaka3"); }
	 */

	public static void main(String[] args) {

		ArrayList<Integer> row1 = new ArrayList<>();

		row1.add(1);
		row1.add(2);
		row1.add(3);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(4);
		row2.add(5);
		row2.add(6);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(9);
		row3.add(8);
		row3.add(9);
		List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(row1);
		arr.add(row2);
		arr.add(row3);
		// System.out.println(diagonalDifference(arr));

//		staircase(6);

//		String input = " }}{{"; // "{{[[(())]]}}";// "[(])"
//		System.out.println(balancedBrackets(input));

//		System.out.println("Counting valleys: " + countingValleys(8, "DDUUUUDD"));

//		System.out.println("Number of pairs: " + sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}));

//		int[][] contests = new int[][] { { 5, 1 }, { 2, 1 }, { 1, 1 }, { 8, 1 }, { 10, 0 }, { 5, 0 } };
//		System.out.println(luckBalance(3, contests));

		/*
		 * SinglyLinkedListNode node3 = new SinglyLinkedListNode(3, null);
		 * SinglyLinkedListNode node2 = new SinglyLinkedListNode(2, node3);
		 * SinglyLinkedListNode node1 = new SinglyLinkedListNode(1, node2);
		 * SinglyLinkedListNode head = new SinglyLinkedListNode(0, node1); int position
		 * = 2; int value = 4; SinglyLinkedListNode n = head;
		 * System.out.println("Before insert"); while (n != null) { System.out.print(n);
		 * n = n.next; }
		 * 
		 * n = insertNodeAt(head, position, value); System.out.println();
		 * System.out.println("After insert"); while (n != null) { System.out.print(n);
		 * n = n.next; }
		 */

		/*
		 * int[] a = {1,2,3,4,5}; Arrays.stream(leftRotationArray(a, 2)).forEach(el ->
		 * System.out.print(el + " "));
		 */

//		outputFormatting();		

		/*
		 * AdmiosTest a = new AdmiosTest(); a.t(null);
		 */

//		System.out.println("Minimu, swaps: " + minimumSwaps(new int[] {7,1,3,2,4,5,6}));
//		System.out.println("Minimu, swaps: " + minimumSwaps(new int[] {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19}));

//		System.out.println(firstNonRepeatingCharacter("aaabcccdeeef"));
//		System.out.println(firstNonRepeatingCharacterArray("aaabcccdeeef"));
//		System.out.println(firstNonRepeatingCharacterHashMap("aaabcccdeeef"));

//		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		System.out.println("Before rotations:");
//		for (int[] a : matrix) {
//			for (int e : a) {
//				System.out.print(e + " ");
//			}
//			System.out.println();
//		}
//
//		rotateImage(matrix);
//		System.out.println("After rotations");
//		for (int[] a : matrix) {
//			for (int e : a) {
//				System.out.print(e + " ");
//			}
//			System.out.println();
//		}
		
		

	}
	
	public static boolean isValidBST(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		double leftChildVal = Double.MAX_VALUE;
		
		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if (root.val <= leftChildVal) return false;
			leftChildVal = root.val;
			root = root.right;
		}
		return true;
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}

		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
	}

	public static int[][] rotateImage(int[][] matrix) {

		int n = matrix.length;

		// Step 1 - Transpose the matrix(turn row into columns)
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		// Step 2 - Flip horizontally
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = tmp;
			}
		}

		return matrix;
	}

	public static char firstNonRepeatingCharacterHashMap(String s) {
		HashMap<Character, Integer> charCounts = new HashMap<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (charCounts.containsKey(c)) {
				charCounts.put(c, charCounts.get(c) + 1);
			} else {
				charCounts.put(c, 1);
			}
		}

		// Iterate again to know the first one, because hashMap has no order.
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (charCounts.get(c) == 1)
				return c;
		}

		return '_';
	}

	public static char firstNonRepeatingCharacterArray(String s) {
		int[] charCounter = new int[26]; // English alphabet all lower case
		char[] letters = s.toCharArray();

		for (char c : letters) {
			charCounter[c - 'a']++; // This is ascii substraction
		}

		for (char c : letters) {
			if (charCounter[c - 'a'] == 1)
				return c;
		}

		return '_';
	}

	public static char firstNonRepeatingCharacter(String s) {
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return s.charAt(i);
		}

		return '_';
	}

	public static int minimumSwaps(int[] arr) {

		int[] copyArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copyArr);
		int differences = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != copyArr[i])
				differences++;
		}

		return differences - 1;
	}

	/**
	 * preorder = root -> left -> right 
	 * inorder = left -> root -> right 
	 * postorder = left -> right - root
	 */
	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}

		System.out.println(root.payload);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static SinglyLinkedListNode mergeList(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		SinglyLinkedListNode head3 = null;
		if (head1.data < head2.data) {
			head3 = head1;
			head1 = head1.next;
		} else {
			head3 = head2;
			head2 = head2.next;
		}

		SinglyLinkedListNode currentNode = head3;
		while (head1 != null && head2 != null) {

			if (head1.data < head2.data) {
				currentNode.next = head1;
				head1 = head1.next;
			} else {
				currentNode.next = head2;
				head2 = head2.next;
			}
			currentNode = currentNode.next;
		}

		if (head1 == null) {
			currentNode.next = head2;
		} else if (head2 == null) {
			currentNode.next = head1;
		}

		return currentNode;
	}

	public static SinglyLinkedListNode reverseLinkedList(SinglyLinkedListNode head) {
		if (head == null)
			return head;

		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode currentNode = head;

		while (currentNode != null) {
			SinglyLinkedListNode nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
		}

		return prev;
	}

	public static void outputFormatting() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			System.out.printf("%-15s %03d\n", s1, x); // Justify to the left 15 spaces, padding number with zeros until
														// length is 3
		}
	}

	public static int[] leftRotationArray(int[] a, int rotations) {
		int size = a.length;
		int[] rotatedArray = new int[size];

		int i = 0;
		int rotateIndex = rotations;

		while (rotateIndex < size) {
			rotatedArray[i] = a[rotateIndex];
			i++;
			rotateIndex++;
		}

		rotateIndex = 0;
		while (rotateIndex < rotations) {
			rotatedArray[i] = a[rotateIndex];
			i++;
			rotateIndex++;
		}

		return rotatedArray;
	}

	public static SinglyLinkedListNode insertNodeAt(SinglyLinkedListNode head, int position, int nodeValue) {

		int index = 0;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(4, null);
		SinglyLinkedListNode currentNode = head;

		while (index < position - 1) {
			index++;
			currentNode = currentNode.next;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;

		return head;
	}

	public static int luckBalance(int k, int[][] contestsLuckImportance) {

		int luckBalance = 0;

		/// descending order
		Arrays.sort(contestsLuckImportance, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return -1 * Integer.compare(a[0], b[0]);
			}
		});
//		Arrays.stream(contestsLuckImportance).forEach(el -> System.out.println(el[0] + " " + el[1]));

		for (int[] contest : contestsLuckImportance) {
			int luck = contest[0];
			int importance = contest[1];

			if (importance == 1 && k > 0) {
				luckBalance += luck;
				k--;
			} else if (importance == 1 && k == 0) {
				luckBalance -= luck;
			} else if (importance == 0) {
				luckBalance += luck;
			}
		}

		return luckBalance;
	}

	public static int sockMerchant(int sockNumber, int[] colors) {

		if (colors.length == 0)
			return 0;

		int numberOfPairs = 0;
		Set<Integer> utilSet = new HashSet<Integer>();

		for (int color : colors) {
			if (!utilSet.contains(color)) {
				utilSet.add(color);
			} else {
				numberOfPairs++;
				utilSet.remove(color);
			}
		}
		return numberOfPairs;
	}

	public static int countingValleys(int steps, String s) {
		int altitude = 0;
		int numberOfValleys = 0;
		for (int i = 0; i < steps; i++) {
			if (s.charAt(i) == 'U') {
				altitude++;
			}
			if (s.charAt(i) == 'D') {
				altitude--;
			}

			if (altitude == -1)
				numberOfValleys++;
		}

		return numberOfValleys;
	}

	public static String balancedBrackets(String input) {
		int inputLength = input.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < inputLength; i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
				stack.push(input.charAt(i));
			} else {
				if (stack.isEmpty())
					return "No";
				else {
					Character popElem = stack.pop();
					if (input.charAt(i) == ')' && popElem != '(') {
						return "No";
					} else if (input.charAt(i) == '}' && popElem != '{') {
						return "No";
					} else if (input.charAt(i) == ']' && popElem != '[') {
						return "No";
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public static int diagonalDifference(List<ArrayList<Integer>> arr) {
		int diagonal = 0;
		for (int i = 0; i < arr.size(); i++) {
			diagonal += arr.get(i).get(i);
			diagonal -= arr.get(i).get(arr.size() - (i + 1));
		}
		return Math.abs(diagonal);
	}

	public static void staircase(int n) {

		for (int numberOfSymbols = 1; numberOfSymbols <= n; numberOfSymbols++) {
			int numberOfSpaces = n - numberOfSymbols;
			for (int j = 0; j < numberOfSpaces; j++) {
				System.out.print(" ");
			}
			for (int z = 0; z < numberOfSymbols; z++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

}
