package linkedinlearning.datascience.knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerRecordUtils {

    public static FlowerRecord parseFlower(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split(",")));

        try {
            Double sepalLength = Double.parseDouble(fields.get(0));
            Double sepalWidth = Double.parseDouble(fields.get(1));
            Double petalLength = Double.parseDouble(fields.get(2));
            Double petalWidth = Double.parseDouble(fields.get(3));
            String species = fields.get(4).trim();

            return new FlowerRecord(sepalLength, sepalWidth, petalLength, petalWidth, species);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
