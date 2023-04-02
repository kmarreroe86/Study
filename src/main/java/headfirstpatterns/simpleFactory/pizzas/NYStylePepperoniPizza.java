package headfirstpatterns.simpleFactory.pizzas;

public class NYStylePepperoniPizza extends Pizza {

	@Override
	public void prepare() {
		System.out.println("preparing NYStyle PepperoniPizza");
	}

	@Override
	public void bake() {
		System.out.println("baking NYStyle PepperoniPizza");
	}

	@Override
	public void cut() {
		System.out.println("cutting NYStyle PepperoniPizza");
	}

	@Override
	public void box() {
		System.out.println("bxing NYStyle PepperoniPizza");
	}

}
