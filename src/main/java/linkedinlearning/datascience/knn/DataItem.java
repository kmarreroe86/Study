package linkedinlearning.datascience.knn;

import java.util.List;

public interface DataItem {

    List<Double> getCoordinates();
    String getClassification();
}
