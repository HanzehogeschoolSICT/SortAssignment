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
 * Class BarChartController
 *
 * @author Koen Hendriks
 * @version 0.1 (09-03-2017)
 */
public class BarChartController {

    /**
     * Create a random BarChart with one serie that is N long
     * and is in random order.
     *
     * @param N int how big the serie should be.
     * @return BarChart with random ordered N values in 1 serie.
     */
    static BarChart<String, Number> getRandomBarChart(int N) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);

        ArrayList<Integer> randomList = BarChartController.getRandomArrayList(N);
        XYChart.Series serie = new XYChart.Series();

        for (int i = 0; i < randomList.size(); i++) {
            serie.getData().add(new XYChart.Data(""+(i+1), randomList.get(i)));
        }

        bc.getData().add(serie);
        bc.setLayoutY(N);

        return styleBarChart(bc);
    }

    /**
     * Method which styles the BarChart with the default settings we have
     * for our application.
     *
     * @param bc BarChart that will be styled.
     * @return BarChart with the correct settings for our application
     */
    private static BarChart<String,Number> styleBarChart(BarChart<String, Number> bc) {
        bc.setMaxHeight(330);
        bc.setPrefWidth(600);
        bc.setBarGap(0);
        bc.setCategoryGap(0);
        bc.setAnimated(false);
        return bc;
    }

    /**
     * Get a ArrayList that counts from 1 to N and sets it in a random order.
     *
     * @param N int how long the array should be.
     * @return ArrayList with N numbers in random order.
     */
    public static ArrayList<Integer> getRandomArrayList(int N){
        ArrayList<Integer> numbers = new ArrayList<>(N);

        for (int i = 1; i < N+1; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers;
    }

    /**
     * Get the first series data from a BarChart
     *
     * @param bc The BarChart object to extract the data from
     * @return ObservableList with the data of the serie
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
