package headfirstpatterns.decorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	protected double cost() {
		return 0.2 + beverage.cost();
	}

}
