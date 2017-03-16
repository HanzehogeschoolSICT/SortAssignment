package Sorting.Controllers.tabControllers;

import Sorting.Controllers.AbstractSortController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.List;

/**
 * Class InsertionSortController
 *
 * @author Ruben Buisman
 * @version 0.1 (08-03-2017)
 */
public class InsertionSortController extends AbstractSortController {

    @FXML
    private AnchorPane insertionSortAnchor;

    @FXML
    private TextField speedTextField;

    private int insertionIndex = 0;

    /**
     * Initialize method that gets called by the FXML when the controller is injected.
     */
    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(insertionSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    /**
     * Do one step forward in the Insertion Sort algorithm. This will get the data
     * from the BarChart and will return the new data as a list with integers.
     *
     * @return List with the new order of the integers
     */
    @Override
    public List<Integer> step() {
        // Get the current Y axis data from the BarChart as a List with integers
        List<Integer> data = super.getSerieData();

        // Stop if we don't have any values anymore.
        if (insertionIndex >= data.size()){
            this.running = false;
        }else{
            return this.insertionSortStep(data);
        }

        return data;
    }

    private List<Integer> insertionSortStep(List<Integer> data) {
        // InsertionSort loop to order the list.
        int key;
        int i;

        key = data.get(insertionIndex);
        for (i = insertionIndex - 1; (i >= 0) && (data.get(i) > key); i--) {
            data.set(i + 1, data.get(i));
        }

        // Put the key in its proper location.
        data.set(i + 1, key);
        insertionIndex++;

        return data;
    }

    /**
     * Reset the tab view with a new BarChart
     */
    @Override
    public void resetButtonPressed(){
        this.insertionIndex = 0;
        super.resetButtonPressed();
    }
}
