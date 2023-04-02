package headfirstpatterns.simpleFactory.pizzas;

import headfirstpatterns.simpleFactory.PizzaIngredientsFactory;

public class CheesePizza extends Pizza {
	
	PizzaIngredientsFactory ingredientsFactory;	
	

	public CheesePizza(PizzaIngredientsFactory ingredientsFactory) {
		super();
		this.ingredientsFactory = ingredientsFactory;
	}



	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientsFactory.createDough();
		sauce = ingredientsFactory.createSauce();
		cheese = ingredientsFactory.createCheese();
		
	}

}
