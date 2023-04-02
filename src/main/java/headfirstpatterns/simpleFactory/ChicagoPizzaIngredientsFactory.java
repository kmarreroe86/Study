package headfirstpatterns.simpleFactory;


import headfirstpatterns.simpleFactory.ingredients.*;

public class ChicagoPizzaIngredientsFactory implements PizzaIngredientsFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new Mozzarella();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[] { new Onion(), new Spinach(), new EggPlant(), new BlackOlives() };
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozeClam();
	}
}
