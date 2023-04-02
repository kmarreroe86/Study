package headfirstpatterns.simpleFactory;


import headfirstpatterns.simpleFactory.pizzas.*;
import headfirstpatterns.simpleFactory.pizzas.Pizza;

public class CaliforniaPizzaStore extends PizzaStoreMain {

	
	public CaliforniaPizzaStore() {
		store = "California store";
	}

	@Override
	protected Pizza createPizza(String type) {
		Pizza p = null;

		switch (type) {
		case "cheese":
			p = new NYStyleCheesePizza();
			break;
		case "pepperoni":
			p = new NYStylePepperoniPizza();
			break;
		case "clam":
			p = new ChicagoStylePepperoniPizza();
			break;
		default:
			break;
		}

		return p;
	}
}
