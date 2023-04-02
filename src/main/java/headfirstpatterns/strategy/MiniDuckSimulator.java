package headfirstpatterns.strategy;

import java.util.Currency;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuack();
		System.out.println(mallard.performQuack());
		System.out.println(mallard.performFly());

		System.out.println("--- modelDuck ---");
		Duck modelDuck = new ModelDuck();
		System.out.println(modelDuck.performFly());
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		System.out.println(modelDuck.performFly());

	}

}
