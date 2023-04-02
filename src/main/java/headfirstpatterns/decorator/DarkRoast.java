package headfirstpatterns.decorator;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "Dark Roast";
	}
	
	protected double cost() {
		return 0.99;
	}

	
	
}
