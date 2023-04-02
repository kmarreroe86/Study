package challanges;

//@FunctionalInterface
public interface TestInterface {

	public abstract void show(int n);

	public void show2(int n);

	public static void hello() {

		System.out.println("static method");

	}

	public default void test() {

		System.out.println("default method");

	}
}
