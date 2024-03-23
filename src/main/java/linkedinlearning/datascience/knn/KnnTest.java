package linkedinlearning.datascience.knn;

import linkedinlearning.datascience.loaddata.TextLoader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KnnTest {

    public static void main(String[] args) {
        File file = new File("src/main/resources/datascience/iris.data");
        List<String> lines = TextLoader.getLines(file.getAbsolutePath());

        List<FlowerRecord> flowers = lines.stream()
                .map(FlowerRecordUtils::parseFlower)
                .collect(Collectors.toList());

        KnnClassifier classifier = new KnnClassifier();
        flowers.forEach(classifier::addDataItem);

        Map<String, Long> classification =  classifier.classifyPoint(new FlowerRecord(7.0,3.2,4.7,1.4, ""), 5);
        System.out.println(classification);
    }
}
