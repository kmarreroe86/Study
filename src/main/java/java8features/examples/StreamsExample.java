package java8features.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		ArrayList<SpaceShip> ships = new ArrayList<>(
				Arrays.asList(
						new SpaceShip("Round", "Mike", 50),
						new SpaceShip("Pyramid", "Susan",65),
						new SpaceShip("Cube", "Ingrid",75),
						new SpaceShip("Banana", "Sored", 15),
						new SpaceShip("Owl", "Lone",25),
						new SpaceShip("Stork", "Ib", 90),
						new SpaceShip("Cone", "Pia",80))
				);
		
		List<String> captainsList = ships.stream()
				.filter(s -> s.fuel >= 50)
				.map(s -> s.captain)
				.sorted()
				.collect(Collectors.toList());
		
		captainsList.stream().forEach(System.out::println);
				
		

	}

}


class SpaceShip {
	String model;
	String captain;
	int fuel;
	
	public SpaceShip(String model, String captain, int fuel) {
		this.captain = captain;
		this.model = model;
		this.fuel = fuel;		
	}
	
}