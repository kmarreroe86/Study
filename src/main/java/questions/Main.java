package questions;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int i = 100;
//		i = (i--) - (--i);
		i = i-- - --i;
		System.out.println(i);
		Base b = new Derived();
		Derived d = new Derived();
		
		b.display();
		d.display();
		b.print();
		
		String strWithDuplicates = "geeksforgeeks";		
		
		Set<Character> noDuplicatesColl = new HashSet<>();
		for (int j = 0; j < strWithDuplicates.length(); j++) {
			noDuplicatesColl.add(strWithDuplicates.charAt(j));
		}
		
		System.out.println("Set collection");
		noDuplicatesColl.stream().sorted().forEach(System.out::print);
	}

}

abstract class Base {
	public static void display() {
		System.out.println("static display from Base");
	}
	
	public void print() {
		System.out.println("non-static print from Base");
	}
}

class Derived extends Base {
	
	public static void display() {
		System.out.println("static display from Derived");
	}
	
	public void print() {
		System.out.println("non-static print from Derived");
	}
}
