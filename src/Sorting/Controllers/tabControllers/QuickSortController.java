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

    private boolean running = false;
    private int speed = 100;


    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(quickSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    public void stepButtonPressed(){
        if(this.running)
            this.running = false;
        redrawBarChart(step());
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
        this.quickSortAnchor.getChildren().removeAll();

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
        quickSortAnchor.getChildren().add(super.bc);
    }
}
