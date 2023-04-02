package questions;

import java.util.Comparator;
import java.util.function.BiConsumer;

public class CapitalizeWords {

    public static void main(String[] args) {

        String str = "hello world";
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (String word : words) {
            sb.append(capitalizeWord(word + " "));
        }

        System.out.println(sb.toString());

        Comparator<Human> comparator
                = (h1, h2) -> h1.getName().compareTo(h2.getName());

        BiConsumer<Integer, Integer> c = (a, b) -> System.out.println("BiConsumer: " + (a + b));
        c.accept(3, 4);
    }

    public static String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}

class Human {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    // standard constructors, getters/setters, equals and hashcode
}