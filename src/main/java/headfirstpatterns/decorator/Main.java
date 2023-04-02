package headfirstpatterns.decorator;

public class Main {

	public static void main(String[] args) {

		Beverage b = new DarkRoast();
		b = new Mocha(b);
		b = new Mocha(b);
		System.out.println(b.getDescription() + " $" + b.cost());

	}

}
