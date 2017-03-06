package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import Sorting.Interfaces.SortableBarChart;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * Created by koen on 3/2/17.
 */
public class BubbleSortController implements SortableBarChart{

    @FXML
    private AnchorPane bubbleSortAnchor;

    private int stepOffset = 0;
    private BarChart<String, Number> bc;

    public void initialize(){
        this.bc = BarChartController.getRandomBarChart(20);
        drawBarChart();
    }

    @Override
    public void step() {
        XYChart.Series<String, Number> series = this.bc.getData().get(0);
        ObservableList<XYChart.Data<String, Number>> numbers = series.getData();

        int firstValue = (int) numbers.get(stepOffset).getYValue();
        int secondValue = (int) numbers.get(stepOffset+1).getYValue();
        System.out.println(numbers.size()+" vs "+this.stepOffset);
        if(this.stepOffset >= numbers.size()-2)
            this.stepOffset = 0;
        else
            this.stepOffset++;

        System.out.println("first: "+firstValue);
        System.out.println("second: "+secondValue);
    }

    public void sort(){
        XYChart.Series<String, Number> series = this.bc.getData().get(0);
        ObservableList<XYChart.Data<String, Number>> numbers = series.getData();
        for (XYChart.Data<String, Number> data : numbers) {
            System.out.println(data.getYValue());
        }
    }

    @Override
    public void drawBarChart() {
        bubbleSortAnchor.getChildren().add(this.bc);
    }
}
