package challanges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

	static int[] shiftPositions(int[]arr, int pos) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i< arr.length;i++) {
			if(i < pos) {
				map.put(arr.length - (pos - i), arr[i]);
			}
			else {
				map.put(i - pos, arr[i]);
			}
		}
		
		for(Entry<Integer, Integer> entry: map.entrySet()) {
			arr[entry.getKey()] = entry.getValue();
		}		
		
		return arr;
	}

	static long repeatedString(String s, long n) {

		long qtyAs = s.chars().filter(ch -> ch == 'a').count();
		long timesString = (n / s.length());
		long remainder = (n % s.length());
		qtyAs = qtyAs * timesString;
		if (remainder > 0)
			qtyAs += s.substring(0, (int) remainder).chars().filter(ch -> ch == 'a').count();

		return qtyAs;
	}

	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> sockPairs = new HashMap<Integer, Integer>();

		for (int color : ar) {
			if (sockPairs.containsKey(color)) {
				sockPairs.put(color, sockPairs.get(color) + 1);
			} else {
				sockPairs.put(color, 1);
			}
		}
		int pairs = 0;

		for (Integer i : sockPairs.values()) {
			pairs += i / 2;
		}
		return pairs;
	}

	// Given a sorted list of integers, square the elements and give the output in sorted order.
	static List<Integer> squareSorted(List<Integer> originalList) {

		return originalList.stream()
				.map(Math::abs)
				.sorted()
				.map(n -> n * n)
				.collect(Collectors.toList());
	}

	/*
	 * static int countingValleys(int n, String s) { int valleys = 0;
	 * Queue<Character> path = new LinkedList<>(); int i = 0; if('D' == s.charAt(0))
	 * { valleys++; i++; path.add(s.charAt(0)); }
	 * 
	 * 
	 * for(; i < n; i++) { if(s.charAt(0) != path.peek()) { char top = path.poll();
	 * if(path.isEmpty()) valleys++; } else { path.add(s.charAt(i)); }
	 * 
	 * }
	 * 
	 * 
	 * return valleys; }
	 */

	public static void main(String[] args) {
		String s = "07:09:45PM";
		String s3 = "07:09:45AM";
		String s4 = "12:00:00AM";
		String s2 = "12:09:45PM";

		String[] timeParts = s.split(":");
		String am_pm = timeParts[timeParts.length - 1].substring(2, 4);
		StringBuilder sb;

		if (am_pm.equals("PM")) {
			int h = Integer.parseInt(timeParts[0]);
			h += h < 12 ? 12 : 0;
			sb = new StringBuilder();
			sb.append(String.valueOf(h)).append(":").append(timeParts[1]).append(":")
					.append(timeParts[timeParts.length - 1].substring(0, 2));

		} else {
			int hour = Integer.valueOf(timeParts[0]);
			if (hour == 12) {
				sb = new StringBuilder();
				sb.append("00:").append(timeParts[1]).append(":")
						.append(timeParts[timeParts.length - 1].substring(0, 2));
			} else {
				sb = new StringBuilder(s.substring(0, s.length() - 2));
			}
		}

		System.out.println(s + ": " + sb.toString());
		int[] n = { 1, 2, 1, 2, 1, 3, 2 };
//        System.out.println(sockMerchant(7, n));
//        countingValleys(8, "UDDDUDUU");

//		System.out.println(repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",6851183689750L));
		System.out.println(repeatedString("a", 1000000000000L));

		int[] arr = {1,2,3,4,5};
		System.out.println("shiftPositions: " + Arrays.toString(shiftPositions(arr, 4)));

		myMethod(null); // calls Integer

		var squaredAndSortedList = squareSorted(Arrays.asList(-9, -2, 0, 2, 3));
		System.out.println("Squared and sorted[-9, -2, 0, 2, 3]: " + squaredAndSortedList);
	}
	static void myMethod(Integer number) {
		System.out.println("Integer");
	}

	static void myMethod(Object object) {
		System.out.println("Integer");
	}
}
