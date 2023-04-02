package headfirstpatterns.strategy;

public class MuteQuack implements QuackBehavior {

	@Override
	public String quack() {
		return "This duck no quack at all. Silence";
	}

}
