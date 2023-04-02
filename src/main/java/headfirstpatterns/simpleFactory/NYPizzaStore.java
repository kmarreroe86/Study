package headfirstpatterns.simpleFactory;


import headfirstpatterns.simpleFactory.pizzas.*;
import headfirstpatterns.simpleFactory.pizzas.Pizza;

public class NYPizzaStore extends PizzaStoreMain {

	
	public NYPizzaStore() {
		store = "New York store";
	}

	@Override
	protected Pizza createPizza(String type) {
		Pizza p = null;
		PizzaIngredientsFactory factory = new NYPizzaIngredientsFactory();

		switch (type) {
		case "cheese":			
			p = new CheesePizza(factory);
			p.setName("New York style cheese pizza");
			break;
		case "pepperoni":
			p = new NYStylePepperoniPizza();
			break;
		case "clam":
			p = new ClamPizza(factory);
			p.setName("New York style clam pizza");
			break;
		default:
			break;
		}

		return p;
	}

}
