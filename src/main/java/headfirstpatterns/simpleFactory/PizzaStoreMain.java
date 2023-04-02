package headfirstpatterns.simpleFactory;

import headfirstpatterns.simpleFactory.pizzas.Pizza;

public abstract class PizzaStoreMain {

	protected String store;

	public Pizza orderPizza(String type) {
		Pizza p = createPizza(type);

		p.prepare();
		p.bake();
		p.cut();
		p.box();

		return p;
	}

	public String getStore() {
		return store;
	}

	protected abstract Pizza createPizza(String type);

	public static void main(String[] args) {
		

		PizzaStoreMain pizzaStore = new NYPizzaStore();
		System.out.println(pizzaStore.getStore());
		pizzaStore.orderPizza("cheese");
		
		System.out.println("-----------------------------");
		
		pizzaStore = new ChicagoPizzaStore();
		System.out.println(pizzaStore.getStore());
		pizzaStore.orderPizza("clam");
	}

}
