package Sorting.Controllers;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

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
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("random numbers");

        for (Integer number : randomList) {
            series1.getData().add(new XYChart.Data(number.toString(), number));
        }

        bc.setMaxHeight(330);
        bc.setPrefWidth(600);
        bc.setBarGap(0);
        bc.setCategoryGap(0);
        bc.getData().add(series1);
        bc.setLayoutY(N);

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
}
