package recursion;

public class Examples {
	
	// head recursion
	public static int factorial(int n) {
		if (n == 0) return 1;		
		return n * factorial(n - 1);
	}
	
	// tail recursion(No need of recursion stack, as we are passing a definitive value in each call. Java does not recognize tail recursion and uses recursion stack)
	private static int factorial(int n, int result) {
		if (n == 0) return result;
		return factorial(n - 1, n * result);
	}
	
	public static int Factorial(int n) {
		return factorial(n, 1);
	}

	public static void main(String[] args) {
		
		System.out.println("Factorial" + factorial(5));

	}

}
