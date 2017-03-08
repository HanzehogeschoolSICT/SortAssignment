package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import Sorting.Interfaces.SortableBarChart;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;
import java.util.List;

/**
 * Class InsertionSortController
 *
 * @author Ruben Buisman
 * @version 0.1 (08-03-2017)
 */
public class InsertionSortController implements SortableBarChart {

    @FXML
    private AnchorPane insertionSortAnchor;
    private BarChart<String, Number> bc;


    // Initialize the barchart
    public void initialize(){
        this.bc = BarChartController.getRandomBarChart(20);
        drawBarChart();
    }

    // Override drawBarChart from interface SortableBarChart
    @Override
    public void drawBarChart() {
        insertionSortAnchor.getChildren().add(this.bc);
    }

    // Override step from interface SortableBarChart
    @Override
    public void step() {
        // Get data
        List<Integer> data = BarChartController.getSeriesData(this.bc);
        System.out.println("old: "+data);

    }

    // Override redrawBarChart from interface SortableBarChart
    @Override
    public void redrawBarChart(List<Integer> data) {
        // Does nothing yet.
    }
}
