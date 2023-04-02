package headfirstpatterns.simpleFactory.pizzas;

import headfirstpatterns.simpleFactory.PizzaIngredientsFactory;

public class ClamPizza extends Pizza {

	PizzaIngredientsFactory ingredientsFactory;

	public ClamPizza(PizzaIngredientsFactory ingredientsFactory) {
		super();
		this.ingredientsFactory = ingredientsFactory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientsFactory.createDough();
		sauce = ingredientsFactory.createSauce();
		cheese = ingredientsFactory.createCheese();
		clams = ingredientsFactory.createClam();
	}

}
