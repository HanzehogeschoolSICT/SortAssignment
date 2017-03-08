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
 * Created by koen on 3/2/17.
 */
public class BubbleSortController implements SortableBarChart{

    @FXML
    private AnchorPane bubbleSortAnchor;

    @FXML
    private TextField speedTextField;

    private boolean running = false;
    private int stepOffset = 0;
    private int finished = 0;
    private int speed = 100;
    private BarChart<String, Number> bc;

    public void initialize(){
        this.bc = BarChartController.getRandomBarChart(20);
        drawBarChart();
    }

    public void stepButtonPressed(){
        if(this.running)
            this.running = false;
        redrawBarChart(step());
    }

    @Override
    public List<Integer> step() {
        List<Integer> data = BarChartController.getSeriesData(this.bc);

        if(finished >= data.size()){
            System.out.println("Done sorting!");
            this.running = false;
        }else {
            int first = data.get(stepOffset);
            int second = data.get(stepOffset + 1);

            if (first > second) {
                data.set(stepOffset, second);
                data.set(stepOffset + 1, first);
            }

            if (stepOffset >= (data.size() - finished) - 2) {
                stepOffset = 0;
                finished++;
                System.out.println("finished: " + this.finished);
            } else {
                stepOffset++;
            }
        }

        return data;
    }

    /**
     * Reset the tab view with a new barchart
     */
    @Override
    public void resetButtonPressed() {
        this.bubbleSortAnchor.getChildren().removeAll();
        this.stepOffset = 0;
        this.finished = 0;

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
        bubbleSortAnchor.getChildren().add(this.bc);
    }

    /**
     * Redraw a barchart with new data
     *
     * @param data List with the new values for the barchart
     */
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
