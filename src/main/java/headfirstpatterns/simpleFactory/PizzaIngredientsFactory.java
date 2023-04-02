package headfirstpatterns.simpleFactory;

import headfirstpatterns.simpleFactory.ingredients.*;

public interface PizzaIngredientsFactory {
	
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();

}
