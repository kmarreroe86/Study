package headfirstpatterns.simpleFactory.pizzas;

public class ChicagoStylePepperoniPizza extends Pizza {

	@Override
	public void prepare() {
		System.out.println("preparing ChicagoStyle pepperoni");
	}

	@Override
	public void bake() {
		System.out.println("baking ChicagoStyle pepperoni");
	}

	@Override
	public void cut() {
		System.out.println("cutting ChicagoStyle pepperoni");
	}

	@Override
	public void box() {
		System.out.println("bxing ChicagoStyle pepperoni");
	}

}
