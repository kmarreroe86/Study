package linkedinlearning.datascience.naivebayes;

import linkedinlearning.datascience.knn.FlowerRecord;
import linkedinlearning.datascience.knn.FlowerRecordUtils;
import linkedinlearning.datascience.loaddata.TextLoader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NaiveBayesTest {

    public static void main(String[] args) {

        File file = new File("src/main/resources/datascience/iris.data");
        List<String> lines = TextLoader.getLines(file.getAbsolutePath());

        List<FlowerRecord> flowers = lines.stream()
                .map(FlowerRecordUtils::parseFlower)
                .collect(Collectors.toList());

        NaivesBayesClassifier classifier = new NaivesBayesClassifier();
        flowers.forEach(classifier::addDataItem);

        Map<String, Double> classification = classifier.classifyPoint(new FlowerRecord(7.0, 3.2, 4.7, 1.4, ""));
    }

}
