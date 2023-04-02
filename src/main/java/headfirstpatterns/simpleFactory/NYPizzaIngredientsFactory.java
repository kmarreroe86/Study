package headfirstpatterns.simpleFactory;

import headfirstpatterns.simpleFactory.ingredients.Cheese;
import headfirstpatterns.simpleFactory.ingredients.*;
import headfirstpatterns.simpleFactory.ingredients.ReggianoCheese;
import headfirstpatterns.simpleFactory.ingredients.Veggies;


public class NYPizzaIngredientsFactory implements PizzaIngredientsFactory {

	@Override
	public Dough createDough() {
		return new ThinCrusrDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[] { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClam();
	}

}
