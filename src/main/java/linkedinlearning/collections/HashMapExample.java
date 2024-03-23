package linkedinlearning.collections;

import java.util.*;

public class HashMapExample {

	public static void main(String[] args) {

		/**
		 * HashMap doesn't keep the order
		 * */
		HashMap<String, Integer> phonebook = new HashMap<>();
		phonebook.put("Kevin", 12345);
		phonebook.put("Jill", 98765);
		phonebook.put("Brenda", 123123);
		phonebook.put("Brenda", 22222);
		phonebook.put(null, 000);
		System.out.println(phonebook);
		if (phonebook.containsKey("Brenda")) {
			phonebook.remove("Brenda");
		}
		phonebook.clear();
		System.out.println(phonebook);

	}

}

class Answer {

	// Change these boolean values to control whether you see
	// the expected result and/or hints.
	static boolean showExpectedResult = false;
	static boolean showHints = false;

	// Return the highest grade for the students with a specific major
	static int findAnswer(List<Student> students, String major) {
		Optional<Integer> maxValue = students.stream()
				.filter(s -> s.getMajor().equals(major))
				.flatMap(e -> e.getGrades().entrySet().stream())
				.map(s -> s.getValue())
				.max((a, b) -> a - b);

		return maxValue.orElse(0);
	}

}

class Student {
	private String firstname;
	private String lastname;
	private String major;
	private Map<String, Integer> grades;

	public Student(String firstname, String lastname, String major, Map<String, Integer> grades) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.major = major;
		this.grades = grades;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMajor() {
		return major;
	}

	public Map<String, Integer> getGrades() {
		return grades;
	}
}
