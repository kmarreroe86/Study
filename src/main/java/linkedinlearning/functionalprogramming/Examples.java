package linkedinlearning.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Don't
        List<Integer> filteredList = new ArrayList<>();
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(n -> filteredList.add(n));
        System.out.println(filteredList);

        // Should
        List<Integer> filteredListBetter = list.stream()
                .filter(x -> x % 2 == 1)
                .collect(Collectors.toList());
        System.out.println(filteredListBetter);

        /***********************/
        // Don't
        AtomicBoolean b1 = new AtomicBoolean();
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(x -> b1.set(true));

        // Should
        boolean b2 = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b2);

        /***********************/
//        Optional help us to avoid using null
        Optional<Integer> opt = Optional.of(5);

        // Procedural way
        if (opt.isPresent()) {
            System.out.println(opt.get());
        } else {
            System.out.println("Option empty");
        }


        // Functional way
        opt.orElse(0);
        opt.orElseThrow(() -> new RuntimeException());
        opt.ifPresentOrElse(
                x -> doSomeThingWithNumber(),
                () -> doSomethingIfNotNumber()
        );

    }

    static void doSomeThingWithNumber() {}

    static void doSomethingIfNotNumber() {}
}

















