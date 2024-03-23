package linkedinlearning.datascience.loaddata;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TextLoading {

    public static void main(String[] args) {
        File file = new File("src/main/resources/datascience/adult-sample.data");

        List<String> lines = TextLoader.getLines(file.getAbsolutePath());
//        System.out.println(lines);

        List<PersonRecord> people = lines.stream()
                .map(line -> PersonRecordUtils.parsePerson(line))
                .collect(Collectors.toList());
        System.out.println(people);

        File fileCars = new File("src/main/resources/datascience/auto-mpg.data");
        lines = TextLoader.getLines(fileCars.getAbsolutePath());
        List<CarRecord> cars = lines.stream()
                .map(CarRecordUtils::parseCar)
                .collect(Collectors.toList());
        System.out.println(cars);
    }
}
