package headfirstpatterns.headfirst.command.remote;

public class GarageDoorOpenCommand implements Command {

	GarageDoor garageDooor;

	public GarageDoorOpenCommand(GarageDoor garageDooor) {
		super();
		this.garageDooor = garageDooor;
	}

	@Override
	public void execute() {
		garageDooor.up();
	}
}
