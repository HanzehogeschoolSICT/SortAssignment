package Sorting.Controllers.tabControllers;

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
 * Class InsertionSortController
 *
 * @author Ruben Buisman
 * @version 0.1 (08-03-2017)
 */
public class InsertionSortController implements SortableBarChart {

    @FXML
    private AnchorPane insertionSortAnchor;

    @FXML
    private TextField speedTextField;

    private BarChart<String, Number> bc;
    private boolean running = false;
    private int speed = 100;
    private int insertionIndex = 0;

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
        int i;

        for (; insertionIndex < data.size(); insertionIndex++) {
            key = data.get(insertionIndex);
            for (i = insertionIndex - 1; (i >= 0) && (data.get(i) > key); i--) {
                data.set(i + 1, data.get(i));
            }

            // Put the key in its proper location.
            data.set(i + 1, key);

            insertionIndex++;
            break;
        }

        // Stop
        if (insertionIndex == data.size()){
            this.running = false;
        }
        return data;
    }

    @Override
    public void stepButtonPressed(){
        if(this.running)
            this.running = false;
        redrawBarChart(step());
    }

    @Override
    public void resetButtonPressed(){
        this.insertionSortAnchor.getChildren().removeAll();
        this.insertionIndex = 0;

        if(running)
            this.running = false;

        this.initialize();
    }

    @Override
    public void sortButtonPressed(){
        new Thread(() -> {
            this.speed = Integer.parseInt(speedTextField.getText());

            System.out.println("starting with "+this.speed);
            this.running = true;

            while(running){
                try {
                    Thread.sleep(this.speed);
                    Platform.runLater(() -> {
                        redrawBarChart(step());
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
