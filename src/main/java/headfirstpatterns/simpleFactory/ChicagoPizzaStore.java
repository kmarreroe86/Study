package headfirstpatterns.simpleFactory;


import headfirstpatterns.simpleFactory.pizzas.*;
import headfirstpatterns.simpleFactory.pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStoreMain {
	
	

	public ChicagoPizzaStore() {
		store = "Chicago store";
	}

	@Override
	protected Pizza createPizza(String type) {
		Pizza p = null;
		PizzaIngredientsFactory factory = new ChicagoPizzaIngredientsFactory();

		switch (type) {
		case "cheese":
			p = new CheesePizza(factory);
			p.setName("Chicago style cheese pizza");
			break;
		case "pepperoni":
			p = new ChicagoStylePepperoniPizza();
			break;
		case "clam":
			p = new ClamPizza(factory);
			p.setName("Chicago style clam pizza");
			break;
		default:
			break;
		}

		return p;
	}

}
