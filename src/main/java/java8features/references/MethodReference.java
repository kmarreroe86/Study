package java8features.references;

import java.util.HashMap;
import java.util.function.BiFunction;

public class MethodReference {

	public static void metallNoise() {
		System.out.println("Klilinnnng Klaannnggg diing");
	}
	
	public static int complextMathOperation(int a, int b) {
		
		return (a + b) * 10;
	}
	
	
	public static void main(String[] args) {
		
		NoiseMaker nm = MethodReference::metallNoise; // Interface method receive implementation through method reference 
		nm.noise();
		nm.doNothing();
		
		HashMap<String, BiFunction<Integer, Integer, Integer>> keyFuncContainer = new HashMap<>();
		
		BiFunction<Integer, Integer, Integer> mathFunc = MethodReference::complextMathOperation;
		int result = mathFunc.apply(10, 20);
		System.out.println("BiFunction result: " + result);
		
	}
	

}

interface NoiseMaker {
	void noise();
	default void doNothing() {System.out.println("kaka");}
}