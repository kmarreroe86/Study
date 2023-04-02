package headfirstpatterns.decorator;

public abstract class Beverage {

	protected String description = "Unknown Beverage";

	protected abstract double cost();
	
	public String getDescription() {
		return description;
	}
	
}
