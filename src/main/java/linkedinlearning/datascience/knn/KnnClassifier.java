package linkedinlearning.datascience.knn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KnnClassifier {

    List<DataItem> dataItems;

    public KnnClassifier() {
        dataItems = new ArrayList<>();
    }

    public void addDataItem(DataItem item) {
        dataItems.add(item);
    }

    public Map<String, Long> classifyPoint(DataItem unlabelledPoint, Integer neighbors) {

        Map<String, Long> pointDistances = dataItems.stream()
                .map(p -> new Pair<>(p.getClassification(), DataItemUtil.getDistance(p, unlabelledPoint)))
                .sorted((d1, d2) -> d1.getValue().compareTo(d2.getValue())) // same as .sorted(Comparator.comparing(Pair::getValue))
                .limit(neighbors)
                .map(p -> p.getKey())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return pointDistances;
    }
}




