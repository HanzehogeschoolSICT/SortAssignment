package Sorting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    private final int N = 20;
    private int latestNumber = N;
    @Override
    public void start(Stage primaryStage) throws Exception{

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


        Parent root = FXMLLoader.load(getClass().getResource("mainLayout.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
