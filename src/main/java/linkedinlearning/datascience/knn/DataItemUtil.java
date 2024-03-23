package linkedinlearning.datascience.knn;

import java.util.List;

public class DataItemUtil {

    public static Double getDistance(DataItem obj1, DataItem obj2) {
        List<Double> obj1Coordinates = obj1.getCoordinates();
        List<Double> obj2Coordinates = obj2.getCoordinates();

        Double sum = 0.0;
        for (int i = 0; i < obj1Coordinates.size(); i++) {
            Double dimensionDistance = obj1Coordinates.get(i) - obj2Coordinates.get(i);
            sum += dimensionDistance;
        }

        return Math.sqrt(sum);
    }
}
