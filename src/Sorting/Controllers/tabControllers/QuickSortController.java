package Sorting.Controllers.tabControllers;

import Sorting.Controllers.AbstractSortController;
import Sorting.Controllers.BarChartController;
import Sorting.Interfaces.SortableBarChart;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.List;
import java.util.Random;

/**
 * Created by koen on 3/2/17.
 */
public class QuickSortController extends AbstractSortController {

    @FXML
    private AnchorPane quickSortAnchor;

    @FXML
    private TextField speedTextField;

    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(quickSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    @Override
    public List<Integer> step() {
        List<Integer> data = super.getSerieData();

        // TODO sort the data with quicksort

        return data;
    }

    /**
     * Reset the tab view with a new barchart
     */
    @Override
    public void resetButtonPressed() {

        // TODO add fields to clear

        super.resetButtonPressed();
    }
}
