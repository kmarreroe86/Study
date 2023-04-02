package headfirstpatterns.strategy;

public class MallardDuack extends Duck {

	public MallardDuack() {
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new Quack();
	}

	@Override
	public String swing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String display() {
		return "I'm a real Mallard duck";
	}

}
