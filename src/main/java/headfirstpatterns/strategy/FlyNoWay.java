package headfirstpatterns.strategy;

public class FlyNoWay implements FlyBehavior {

	@Override
	public String fly() {
		return "This duck can not fly";
	}

}
