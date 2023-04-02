package headfirstpatterns.strategy;

public class FlyWithWings implements FlyBehavior {

	@Override
	public String fly() {
		return "This duck is flying using winds";
	}

}
