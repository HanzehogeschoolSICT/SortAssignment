package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import Sorting.Interfaces.SortableBarChart;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.util.List;
import java.util.Random;

/**
 * Class InsertionSortController
 *
 * @author Ruben Buisman
 * @version 0.1 (08-03-2017)
 */
public class InsertionSortController extends supercontroller implements SortableBarChart {

    @FXML
    private AnchorPane insertionSortAnchor;
    private BarChart<String, Number> bc;

    public int p = 0;

    // Initialize the barchart
    public void initialize(){
        this.bc = BarChartController.getRandomBarChart(20);
        drawBarChart();
    }

    @Override
    public List<Integer> step() {
        // Get the list from the barchart.
        List<Integer> data = BarChartController.getSeriesData(this.bc);

        // InsertionSort loop to order the list.
        int key;
        int index;

        for (; p < data.size(); p++) {
            key = data.get(p);
            for (index = p - 1; (index >= 0) && (data.get(index) > key); index--) {
                data.set(index + 1, data.get(index));
            }
            // Put the key in its proper location.
            data.set(index + 1, key);

            // Redraw the barchart with the new list.
            redrawBarChart(data);

            p++;
            break;
        }
        return data;
    }

    @Override
    public void stepButtonPressed(){
        // Does nothing yet.
    }

    @Override
    public void resetButtonPressed(){
        // Does nothing yet.
    }

    @Override
    public void sortButtonPressed(){
        // Does nothing yet.
    }

    @Override
    public void drawBarChart() {
        insertionSortAnchor.getChildren().add(this.bc);
    }

    @Override
    public void redrawBarChart(List<Integer> data) {
        this.bc.getData().remove(0);
        XYChart.Series serie = new XYChart.Series();
        serie.setName("test");
        Random r = new Random();

        for (int i = 0; i < data.size(); i++) {
            serie.getData().add(new XYChart.Data(""+(i+1), data.get(i)));
        }

        this.bc.getData().add(serie);
    }
}