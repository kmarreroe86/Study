package linkedinlearning.fp.workingWithStream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collecting2 {

    public static void main(String[] args) {

        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);


        /** Grouping by age */
        Map<Integer, List<Employee>> employeesByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(employeesByAge);


        /** Grouping using Function and Collectors
         * Function.identity() — represents the item in the [Function]
         * Collectors.counting() — counts the elements [Collector]
         * */

        // Ex1
        List<String> fruitNames = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> fruitsCounter = fruitNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(fruitsCounter);

        // Ex2
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        Map<String, Integer> itemsCounter = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(itemsCounter);


        Map<Integer, List<String>> employeeNamesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getAge,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(employeeNamesByAge);


        /**
         * Group By with Function, Supplier and Collector
         * */
        Map<BigDecimal, Set<String>> itemsByPrice = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        System.out.println(itemsByPrice);

        // Grouping and Sorting by the price. Use Treemap
        // Ex1
        Map<BigDecimal, Set<String>> sortedItemsByPrice = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                TreeMap::new,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        System.out.println(sortedItemsByPrice);

        // Ex2
        Map<Integer, Set<String>> sortedEmployeesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getAge,
                                TreeMap::new,
                                Collectors.mapping(Employee::getName, Collectors.toSet())
                        )
                );
        System.out.println(sortedEmployeesByAge);

    }

    static class Employee {

        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Item {
        private String name;
        private int qty;
        private BigDecimal price;

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }
    }
}
