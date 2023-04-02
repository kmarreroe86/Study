package test;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toList;

/**
 * truelogic exercise
 * https://codesandbox.io/s/ts-challenge-mvwx5?file=/src/index.ts:802-817
 * */
public class School {

    private Map<Integer, List<String>> dataSource = new HashMap<>();

    public void addStudent(String student, Integer grade) {
        if (!dataSource.containsKey(grade)) {
            dataSource.put(grade, new ArrayList<>(Arrays.asList(student)));
        } else {
            var currentStudentList = dataSource.get(grade);
            currentStudentList.add(student);
        }
    }


    public List<RosterDto> getSortedRoster() {
        List<RosterDto> roster = dataSource.entrySet()
                .stream()
                .sorted(comparingByKey()) //
                .map(entry -> new RosterDto(entry.getKey(), entry.getValue()))
                .collect(toList());

        return roster;
    }


    public static void main(String[] args) {

        School school = new School();
        school.addStudent("tom", 2);
        school.addStudent("ian", 2);
        school.addStudent("fred", 2);
        school.addStudent("alice", 1);
        school.addStudent("victor", 1);
        school.addStudent("chris", 3);
        school.addStudent("kim", 3);
        school.addStudent("sam", 3);


        List<RosterDto> roster = school.getSortedRoster();
        System.out.println(roster);

    }
}

class RosterDto {
    private Integer grade;
    private List<String> students;

    public RosterDto(Integer grade, List<String> students) {
        this.grade = grade;
        this.students = students;
    }

    @Override
    public String toString() {
        return "RosterDto{" +
                "grade=" + grade +
                ", students=" + students +
                '}';
    }
}
