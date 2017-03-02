package Sorting.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;


public class MainController extends VBox{

    @FXML
    private TabPane sortingTabPane;

    public void initialize() {
        this.createTabs();
    }

    /**
     * Create the tabs for each sorting algorithm and the about tab
     */
    private void createTabs() {

        ObservableList<Tab> tabs = this.sortingTabPane.getTabs();

        // TODO: Dynamicly load the tabs from the Views/Tabs folder
        try {
            tabs.addAll(
                    FXMLLoader.load(
                       getClass().getResource("../Views/Tabs/BubbleSort.fxml")
                    ),
                    FXMLLoader.load(
                            getClass().getResource("../Views/Tabs/InsertionSort.fxml")
                    ),
                    FXMLLoader.load(
                            getClass().getResource("../Views/Tabs/QuickSort.fxml")
                    ),
                    FXMLLoader.load(
                            getClass().getResource("../Views/Tabs/About.fxml")
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
