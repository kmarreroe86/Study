package headfirstpatterns.strategy;

public abstract class Duck {

	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public String performQuack() {
		return quackBehavior.quack();
	}

	public String performFly() {
		return flyBehavior.fly();
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public String swing() {
		return "All ducks float, even decoys!";
	};

	public abstract String display();

}
