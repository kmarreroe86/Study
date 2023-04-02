package java8features.examples;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		
		Optional<String> message = Optional.empty();
		System.out.println("is present: " + message.isPresent());
		String result = message.orElse("You have no messages");
		System.out.println(result);
		
		message = Optional.of("Remember to buy Milk and flour!");
		String otherResult = message.orElse("You have no messages.");
		System.out.println(otherResult);

	}

}
