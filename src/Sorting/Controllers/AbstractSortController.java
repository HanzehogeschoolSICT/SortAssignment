package Sorting.Controllers;

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
 * Class AbstractSortController
 *
 * @author Koen Hendriks
 * @version 0.1 (09-03-2017)
 */
public abstract class AbstractSortController implements SortableBarChart{


    private TextField speedTextField;
    private AnchorPane anchorPane;

    protected BarChart bc;
    protected int speed;

    protected boolean running = false;

    protected void initialize(){
        bc = BarChartController.getRandomBarChart(20);
        drawBarChart();
    }

    /**
     * Make one step of the sorting algorithm.
     * This stops the sorting thread if its running.
     */
    public void stepButtonPressed() {
        if(running)
            running = false;
        redrawBarChart(step());
    }

    /**
     * Reset the tab view with a new barchart
     */
    public void resetButtonPressed() {
        anchorPane.getChildren().removeAll();

        if(running)
            running = false;

        initialize();
    }

    /**
     * Called when the sort button is pressed and
     * starts a new thread to do the sorting.
     */
    public void sortButtonPressed() {
        new Thread(() -> {
            speed = Integer.parseInt(speedTextField.getText());

            running = true;

            while(running){
                try {
                    Thread.sleep(speed);
                    Platform.runLater(() -> {
                        redrawBarChart(step());
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void drawBarChart() {
        anchorPane.getChildren().add(bc);
    }

    /**
     * Redraw a barchart with new data
     *
     * @param data List with the new values for the barchart
     */
    public void redrawBarChart(List<Integer> data) {
        bc.getData().remove(0);
        XYChart.Series serie = new XYChart.Series();

        for (int i = 0; i < data.size(); i++) {
            serie.getData().add(new XYChart.Data(""+(i+1), data.get(i)));
        }

        bc.getData().add(serie);
    }

    protected void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setSpeedTextField(TextField speedTextField) {
        this.speedTextField = speedTextField;
    }
}
