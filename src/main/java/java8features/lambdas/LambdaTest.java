package java8features.lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
	
	public static void main(String[] args) {
		
		Runnable r = () -> System.out.println("This is a runnable");
		r.run();
		
		// lambda with arguments
		System.out.println("\nLambda with arguments");
		lambdaWithArguments();
		
		// loop with lambda
		System.out.println("\nLoop with lambda");
		listWithLoopLambda();
	}
	
	public static void lambdaWithArguments() {
		CargoSpace c1 = (qty, stuff) -> "We have " + qty + " pcs of " + stuff; 
		CargoSpace c2 = (qty, stuff) -> {
			return  "We have " + qty + " quantity of " + stuff;
		};
		
		System.out.println(c1.content(3, "motherboard"));
		System.out.println(c2.content(47, "memory"));
	}
	
	public static void listWithLoopLambda() {
		List<String> cargoTypes = new ArrayList<>();
		cargoTypes.add("Bananas");
		cargoTypes.add("Oranges");
		cargoTypes.add("Coconuts");
		cargoTypes.add("Wheat");
		
		cargoTypes.forEach(System.out::println);
		cargoTypes.forEach(s -> {
			System.out.println("The cargo type is: " + s);
		});
	}

}

/**
 * Interface with only 1 method
 * */
@FunctionalInterface
interface CargoSpace {
	String content(int qty, String stuff);
}
