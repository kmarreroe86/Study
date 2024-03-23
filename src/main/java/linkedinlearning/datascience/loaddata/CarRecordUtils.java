package linkedinlearning.datascience.loaddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRecordUtils {

    public static CarRecord parseCar(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split("\\s+"))); // split by whitespace (tabs)

        try {
            Float mpg = Float.parseFloat(fields.get(0).trim());
            Integer numbersOfCylinders = Integer.parseInt(fields.get(1).trim());
            Float displacement = Float.parseFloat(fields.get(2).trim());
            Float weight = Float.parseFloat(fields.get(4).trim());
            Integer year = Integer.parseInt(fields.get(6).trim());
            Integer origin = Integer.parseInt(fields.get(7).trim());

            return new CarRecord(mpg, numbersOfCylinders, displacement, weight, year, origin);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
