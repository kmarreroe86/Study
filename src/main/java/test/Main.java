package test;

import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map = new TreeMap<>();
		map.put("a", "123");
		map.put("c", "456");
		map.put("b", "789");
		map.put("a", "543");

		System.out.println(map);

	}

}
