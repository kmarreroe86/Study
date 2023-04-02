package headfirstpatterns.strategy;

public class Quack implements QuackBehavior {

	@Override
	public String quack() {
		return "This duck quack as living duck";
	}

}
