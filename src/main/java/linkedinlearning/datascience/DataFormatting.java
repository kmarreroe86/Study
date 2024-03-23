package linkedinlearning.datascience;

import java.util.ArrayList;
import java.util.List;

public class DataFormatting {

    static class Person {
        public final Integer id;
        public final String name;
        public final Boolean likesPizza;

        public Person(Integer id, String name, Boolean likesPizza) {
            this.id = id;
            this.name = name;
            this.likesPizza = likesPizza;
        }
    }

    static class PersonUtils {
        public static String getFirstName(Person person) {
            return person.name.split(" ")[0];
        }
    }

    public static void main(String[] args) {

        //Univariate arrays (Contains the values for each data point. Ex: values for a single column in database table)
        String[] names = {"John Doe", "Jane Jones", "Bill Smith", "Bob Dylan"};
        Integer[] ids = {123, 456, 789, 147};
        Boolean[] likesPizza = {true, false, false, true};


        // Multivariate array. Represents a row in the dataset, but all data should be the same type
        Integer[] person1 = {123, 0, 1994, 4, 3}; // id, likesPizza, yearOfBirth, dayOfBirth, monthOfBirth
        Integer[] person2 = {456, 1, 1940, 8, 4}; // id, likesPizza, yearOfBirth, dayOfBirth, monthOfBirth

        // Matrices (Multivariate array)
        // id, likesPizza, yearOfBirth, dayOfBirth, monthOfBirth
        double[][] persons = {
                {123, 0, 1994, 4, 3},
                {456, 1, 1940, 8, 4}
        };


        // Data Objects
        Person person = new Person(123, "John Doe", false);
        String firstName = PersonUtils.getFirstName(person);

        List<Person> peopleList = new ArrayList();
        peopleList.add(new Person(123, "John Doe", false));
        peopleList.add(new Person(234, "Jane Jones", true));
    }
}
