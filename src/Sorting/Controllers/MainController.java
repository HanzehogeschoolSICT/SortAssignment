package Sorting.Controllers;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MainController {

    private Scene scene;

    public MainController(Scene scene) {
        this.scene = scene;
        Node bubbleSort = scene.lookup("#bubblesortAnchor");
        AnchorPane bubbleSortTab = (AnchorPane) bubbleSort;

        BarChart<String, Number> bc = getRandomBarChart(20);

        bubbleSortTab.getChildren().add(bc);
    }

    private BarChart<String, Number> getRandomBarChart(int N) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);

        ArrayList<Integer> randomList = this.getRandomArrayList(N);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("random numbers");

        for (Integer number : randomList) {
            series1.getData().add(new XYChart.Data(""+number, number));
        }

        bc.setMaxHeight(300);
        bc.setBarGap(0);
        bc.setCategoryGap(0);
        bc.getData().add(series1);

        return bc;
    }

    private ArrayList<Integer> getRandomArrayList(int N){
        ArrayList<Integer> numbers = new ArrayList<>(N);

        for (int i = 1; i < N+1; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> randomNumberList = new ArrayList<>(N);

        Random rand = new Random();
        while(numbers.size() > 0){
            int randomIndex = rand.nextInt(numbers.size());
            randomNumberList.add(numbers.get(randomIndex));
            numbers.remove(randomIndex);
        }

        return randomNumberList;
    }
}
