package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import Sorting.Interfaces.SortableBarChart;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.util.List;
import java.util.Random;

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
        List<Integer> data = BarChartController.getSeriesData(this.bc);

        System.out.println("old: "+data);

        int first = data.get(stepOffset);
        int second = data.get(stepOffset+1);

        if(first > second){
            data.set(stepOffset,second);
            data.set(stepOffset+1, first);
        }

        if(stepOffset >= data.size() -2)
            stepOffset = 0;
        else
            stepOffset++;

        redrawBarChart(data);
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

    /**
     * Redraw a barchart with new data
     * @param data List with the new values for the barchart
     */
    @Override
    public void redrawBarChart(List<Integer> data) {
        this.bc.getData().remove(0);

        System.out.println("new: "+data);
        XYChart.Series serie = new XYChart.Series();
        serie.setName("test");
        Random r = new Random();

        for (int i = 0; i < data.size(); i++) {
            serie.getData().add(new XYChart.Data(""+i, data.get(i)));
        }

        this.bc.getData().add(serie);

    }
}
