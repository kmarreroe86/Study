package headfirstpatterns.simpleFactory.pizzas;

import java.util.ArrayList;
import java.util.List;

import headfirstpatterns.simpleFactory.ingredients.Cheese;
import headfirstpatterns.simpleFactory.ingredients.Clams;
import headfirstpatterns.simpleFactory.ingredients.Dough;
import headfirstpatterns.simpleFactory.ingredients.Pepperoni;
import headfirstpatterns.simpleFactory.ingredients.Sauce;
import headfirstpatterns.simpleFactory.ingredients.Veggies;

public abstract class Pizza {

	protected String name;

	protected Dough dough; // masa

	protected Sauce sauce;
	
	protected Cheese cheese;
	
	protected Pepperoni pepperoni;
	
	protected Veggies[] veggies;
	
	protected Clams clams;
	

//	protected List<String> toppings = new ArrayList<String>();

	/*
	 * public void prepare() { System.out.println("Preparing: " + name);
	 * System.out.println("Tossing dough..."); System.out.println("Adding souce: " +
	 * sauce); System.out.println("Adding toppings"); toppings.forEach(t ->
	 * System.out.println(t)); }
	 */

	public abstract void prepare();
	
	public void bake() {
		System.out.println("Bake for 25 min at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
