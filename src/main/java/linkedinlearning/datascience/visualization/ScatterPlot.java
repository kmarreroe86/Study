package linkedinlearning.datascience.visualization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import linkedinlearning.datascience.loaddata.CarRecord;
import linkedinlearning.datascience.loaddata.CarRecordUtils;
import linkedinlearning.datascience.loaddata.TextLoader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javafx.scene.chart.XYChart.*;

public class ScatterPlot extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        File fileCars = new File("src/main/resources/datascience/auto-mpg.data");
        List<String> lines = TextLoader.getLines(fileCars.getAbsolutePath());

        // Get the data
        List<CarRecord> carRecords = lines.stream()
                .map(l -> CarRecordUtils.parseCar(l))
                .collect(Collectors.toList());

        Map<Boolean, List<CarRecord>> oldCarsMap = carRecords.stream()
                .collect(Collectors.partitioningBy(c -> c.year <= 76));
        Series olderCarSeries = new Series();
        oldCarsMap.get(true).forEach(car -> olderCarSeries.getData().add(new Data(car.weight, car.mpg)));

        Series newestCarSeries = new Series();
        oldCarsMap.get(false).forEach(car -> newestCarSeries.getData().add(new Data(car.weight, car.mpg)));

        // Set up axis
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight");
        yAxis.setLabel("MPG");
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);

        // Add data to the series
        scatterChart.getData().add(olderCarSeries);
        scatterChart.getData().add(newestCarSeries);

        // Config the chart
        scatterChart.setTitle("Weight vs. Mileage");
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);
        scatterChart.setHorizontalZeroLineVisible(false);

        // Draw and lunch the app
        Scene scene = new Scene(scatterChart, 900, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


















