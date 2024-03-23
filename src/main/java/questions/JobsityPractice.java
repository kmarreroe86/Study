package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class JobsityPractice {

	public static void main(String[] args) {

		String s1 = "AAABBB";
		String s2 = "AAAA";
		String s3 = "BBBBB";
		String s4 = "BABABA";

		char[] array = s4.toCharArray();
		int counter = 0;
		char character = array[0];

		for (int i = 1; i < array.length; i++) {
			if (character == array[i]) {
				counter++;
			}
			character = array[i];

		}

//		System.out.println(counter);
//		System.out.println();
//		System.out.println("makeAnagram: " + makeAnagram("bacdc", "dcbad"));

//		System.out.println("Max toys: " + maximumToys(new int[] { 1, 2,3, 4 }, 7));

		/*Player p1 = new Player("amy", 100);
		Player p2 = new Player("david", 100);
		Player p3 = new Player("heraldo", 50);
		Player p4 = new Player("aakansha", 75);
		Player p5 = new Player("aleksa", 150);
		List<Player> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.stream().forEach(p -> System.out.println("[" + p.name + " " + p.score + "]"));
		System.out.println("-----------------------");
		list.sort(new Checker());
		list.stream().forEach(p -> System.out.println("[" + p.name + " " + p.score + "]"));*/
		
		System.out.println(isBalanced("{(([])[])[]}[]"));

	}

	static int makeAnagram(String a, String b) {
		int deletions = 0;
		List<String> arrayA = new ArrayList<>(Arrays.asList(a)); // a.toCharArray();
		List<String> arrayB = new ArrayList<>(Arrays.asList(b));

		Collections.sort(arrayA);
		Collections.sort(arrayB);

		int length = arrayA.size();
		for (int i = 0; i < length; i++) {
			if (arrayA.get(i).equals(arrayB.get(i))) continue;
			arrayA.remove(i);
			arrayB.remove(i);
			deletions += 2;

		}

//		boolean kaka = arrayB.retainAll(arrayA);
		/*
		 * arrayA.stream().forEach(elem -> System.out.print( elem.toUpperCase()));
		 * System.out.println();
		 */
		arrayB.stream().forEach(elem -> System.out.print(elem.toUpperCase()));

		/*
		 * Arrays.sort(arrayA); Arrays.sort(arrayB);
		 * 
		 * if (arrayA.length > arrayB.length) { deletions = arrayA.length -
		 * arrayB.length; for (int i = 0; i < arrayB.length; i++) { if (arrayA[i] !=
		 * arrayB[i]) { deletions++; } }
		 * 
		 * } else if (arrayA.length <= arrayB.length) { deletions = arrayB.length -
		 * arrayA.length; for (int i = 0; i < arrayA.length; i++) { if (arrayA[i] !=
		 * arrayB[i]) { deletions++; } } }
		 */

		return deletions;

	}

	public static int maximumToys(int[] prices, int k) {
		int n = 0;
		Arrays.sort(prices);
		for (int price : prices) {
			if ((k - price) < 0) break;
			k -= price;
			n++;
		}

		return n;
	}

	static String isBalanced(String s) {
		
		char[] charArray = s.toCharArray();
		if (charArray.length % 2 == 1) return "NO";
		Stack<Character> symbols = new Stack<>();
		symbols.add(charArray[0]);
		for(int i = 1; i < charArray.length; i++) {
			if(!symbols.isEmpty() && matches(symbols.peek(), charArray[i])) {
				symbols.pop();
			} else {
				symbols.add(charArray[i]);
			}
		}
		return symbols.isEmpty() ? "YES" : "NO";
	}
	
	static boolean matches(char openChar, char closeChar) {
		boolean characteresMatches = false;
		switch (openChar) {
		case '{':
			characteresMatches = closeChar == '}';
			break;
		case '[':
			characteresMatches = closeChar == ']';
			break;
		case '(':
			characteresMatches = closeChar == ')';
			break;
		default:
			characteresMatches = false;
			break;
		}
		
		return characteresMatches;
	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

final class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {
		if (a.score < b.score) {
			return 1;
		} else if (a.score == b.score) {
			return a.name.compareTo(b.name);
		} else
			return -1;
	}
}
