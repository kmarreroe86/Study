package linkedinlearning.datascience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataManipulation {

    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numbers = new ArrayList(Arrays.asList(intArray));

        String[] wordsArr = {"hello", "data", "science", "is", "cool"};
        List<String> words = new ArrayList(Arrays.asList(wordsArr));

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList(Arrays.asList(employeesArr));


        // Mapping
        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        doubledNumbers.stream().forEach(System.out::println);

        List<String> uppercasedWords = words.stream()
                .map(w -> w.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(uppercasedWords);


        List<String> names = employees.stream()
                .map(e -> e.name)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(names);


        // Filter
        List<String> longWords = words.stream()
                .filter(w -> w.length() > 4)
                .collect(Collectors.toList());
        System.out.println(longWords);

        List<String> employeesWellPaid = employees.stream()
                .filter(e -> e.salary > 75000)
//                .sorted(Comparator.comparing(o -> o.salary))  // ordering asc
                .sorted((o1, o2) -> o2.salary.compareTo(o1.salary))
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println(employeesWellPaid);


        /*Challenge. Get names of all employees over 30 years sort by salary asc*/
        List<Employee> employeesOver30Years =
                employees.stream()
                .filter(e -> e.age > 30)
                .sorted(Comparator.comparing(e -> e.salary))
                        .collect(Collectors.toList());
        employeesOver30Years.forEach(System.out::println);

    }
}
