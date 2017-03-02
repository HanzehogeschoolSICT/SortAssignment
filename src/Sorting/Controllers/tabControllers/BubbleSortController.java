package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;

/**
 * Created by koen on 3/2/17.
 */
public class BubbleSortController{

    @FXML
    private AnchorPane bubbleSortAnchor;

    private BarChart bc;

    public void initialize(){

        this.bc = BarChartController.getRandomBarChart(20);
        bubbleSortAnchor.getChildren().add(this.bc);
    }
}
