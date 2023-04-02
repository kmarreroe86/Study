package headfirstpatterns.strategy;

public class Squeak implements QuackBehavior {

	@Override
	public String quack() {		
		return "This is a rubber duck and not quack, squaek instead";
	}

}
