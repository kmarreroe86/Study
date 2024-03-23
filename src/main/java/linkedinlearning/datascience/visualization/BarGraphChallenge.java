package linkedinlearning.datascience.visualization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import linkedinlearning.datascience.loaddata.CarRecord;
import linkedinlearning.datascience.loaddata.CarRecordUtils;
import linkedinlearning.datascience.loaddata.TextLoader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Show bar graph chart of the average mpg of cars, based on their origin
* 1 - america
* 2 - europe
* 3 - asia */
public class BarGraphChallenge extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        File fileCars = new File("src/main/resources/datascience/auto-mpg.data");
        List<String> lines = TextLoader.getLines(fileCars.getAbsolutePath());

        // Get the data
        List<CarRecord> carRecords = lines.stream()
                .map(CarRecordUtils::parseCar)
                .collect(Collectors.toList());

        Map<Integer, List<CarRecord>> carsOriginMap = carRecords.stream()
                .collect(Collectors.groupingBy(
                        (car) -> car.origin
                ));

        Series series =  new Series();
        carsOriginMap.entrySet().forEach(el -> {
            series.getData().add(
                    new Data(
                            el.getKey() == 1 ? "America" : el.getKey() == 2 ? "Europe" : "Asia",
                            el.getValue().stream()
                                    .map(c -> c.mpg)
                                    .reduce(0f,(acc, x) -> acc + x) / el.getValue().size()
                    )
            );
        });

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Origin");
        yAxis.setLabel("Average mpg");

        BarChart<String, Number> barChart = new BarChart(xAxis, yAxis);
        barChart.setAnimated(false);
        barChart.getData().add(series);
        barChart.setTitle("Average mpg from different origins");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(barChart, 900, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
























