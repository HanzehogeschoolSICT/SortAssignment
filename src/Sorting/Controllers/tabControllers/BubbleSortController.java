package Sorting.Controllers.tabControllers;

import Sorting.Controllers.AbstractSortController;
import Sorting.Controllers.BarChartController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.List;

/**
 * Class BubbleSortController
 *
 * @author Koen Hendriks
 * @version 0.1 (09-03-2017)
 */
public class BubbleSortController extends AbstractSortController{

    @FXML
    private TextField speedTextField;

    @FXML
    public AnchorPane bubbleSortAnchor;

    private int stepOffset = 0;
    private int finished = 0;
    private int speed = 100;

    /**
     * Initialize method that gets called by the FXML when the controller is injected.
     */
    @Override
    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(bubbleSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    /**
     * Do one step forward in the Bubble Sort algorithm. This will get the data
     * from the BarChart and will return the new data as a list with integers.
     *
     * @return List with the new order of the integers
     */
    @Override
    public List<Integer> step() {
        // Get the current Y axis data from the BarChart as a List with integers
        List<Integer> data = super.getSerieData();

        // Stop running if we are finished
        if(finished >= data.size()){
            this.running = false;
        }else {
            /*
              Set the first two values for the Bubble Sort algorithm.
              These values come from the BarChart with the offset that
              we keep track on.
             */
            int first = data.get(stepOffset);
            int second = data.get(stepOffset + 1);

            // If the first value is bigger then second we swap them.
            if (first > second) {
                data.set(stepOffset, second);
                data.set(stepOffset + 1, first);
            }

            /*
             Subtract the finished values from the array size,
             this way it won't repeat the step of the values
             that are already sorted at the end of the array.
              */
            if (stepOffset >= (data.size() - finished) - 2) {
                stepOffset = 0;
                finished++;
            } else {
                stepOffset++;
            }
        }

        return data;
    }

    /**
     * Reset the tab view with a new BarChart
     */
    @Override
    public void resetButtonPressed() {
        this.stepOffset = 0;
        this.finished = 0;
        super.resetButtonPressed();
    }
}
