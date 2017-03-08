package Sorting.Controllers;

import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koen on 3/2/17.
 */
public class BarChartController {

    /**
     * Create a random barchart with one serie that is N long
     * and is in random order.
     *
     * @param N int how big the serie should be
     * @return BarChart with random ordered N values in 1 serie
     */
    public static BarChart<String, Number> getRandomBarChart(int N) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);

        ArrayList<Integer> randomList = BarChartController.getRandomArrayList(N);
        XYChart.Series serie = new XYChart.Series();
        serie.setName("random numbers");

        for (int i = 0; i < randomList.size(); i++) {
            serie.getData().add(new XYChart.Data(""+(i+1), randomList.get(i)));
        }

        bc.setMaxHeight(330);
        bc.setPrefWidth(600);
        bc.setBarGap(0);
        bc.setCategoryGap(0);
        bc.getData().add(serie);
        bc.setLayoutY(N);
        bc.setAnimated(false);

        return bc;
    }

    /**
     * Get a ArrayList that counts from 1 to N and sets it in a random order.
     *
     * @param N int how long the array should be.
     * @return ArrayList with N numbers in random order.
     */
    private static ArrayList<Integer> getRandomArrayList(int N){
        ArrayList<Integer> numbers = new ArrayList<>(N);

        for (int i = 1; i < N+1; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers;
    }

    /**
     * Get the first series data from a barchart
     *
     * @param bc The barchart object to extract the data from
     * @return Observablelist with the data of the serie
     */
    public static List<Integer> getSeriesData(BarChart<String, Number> bc){
        List<Integer> serieData = new ArrayList<>();
        XYChart.Series<String, Number> series = bc.getData().get(0);
        ObservableList<XYChart.Data<String, Number>> numbers = series.getData();
        for (XYChart.Data<String, Number> data : numbers) {
            serieData.add((Integer) data.getYValue());
        }

        return serieData;
    }
}
