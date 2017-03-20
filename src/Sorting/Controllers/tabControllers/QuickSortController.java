package Sorting.Controllers.tabControllers;

import Sorting.Controllers.AbstractSortController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.List;


/**
 * Class QuickSortController
 *
 * @author Koen Hendriks & Ruben Buisman
 * @version 0.3 (02-03-2017)
 */
public class QuickSortController extends AbstractSortController {

    @FXML
    private AnchorPane quickSortAnchor;

    @FXML
    private TextField speedTextField;

    // tempData for swap method
    private List<Integer> stepData;

    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(quickSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    /**
     * Boolean to see if we finished with QuickSort
     *
     * @return boolean if we need to keep sorting
     */
    private boolean keepRunning(){
        for(int x = 1; x < stepData.size(); x++) {
            int lowValue = stepData.get(x-1);
            int highValue = stepData.get(x);

            if(lowValue > highValue) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Integer> step() {
        // Get the current Y axis data from the BarChart as a List with integers
        final List<Integer> data = super.getSerieData();

        stepQuickSort(data);
        return data;
    }

    private List<Integer> stepQuickSort(List<Integer> data) {
        stepData = data;
        if(!keepRunning()) {
            running = false;
        }else {
            return quickSort(0, (stepData.size() - 1));
        }
        return stepData;
    }

    /**
     * Quicksort method to call recursively.
     *
     * @param lowest number for the quicksort
     * @param highest number for the quicksort
     * @return List with sorted data.
     */
    private List<Integer> quickSort(int lowest, int highest){
        final List<Integer> data = super.getSerieData();
        int low = lowest;
        int high = highest;
        int pivot = data.get(lowest + ((highest - lowest) / 2));

        while (low <= high){
            while (data.get(low) < pivot){
                low ++;
            }
            while (data.get(high) > pivot){
                high--;
            }
            if(low <= high){
                swapValues(low, high);
                low++;
                high--;
                break;
            }
        }

        if (lowest < high ) {
            quickSort(lowest, high);
        }

        if (low < highest) {
            quickSort(low, highest);
        }
        return data;
    }

    /**
     * Switch 2 values in the QuickSort data arraylist
     *
     * @param i first value to swap
     * @param j second value to swap
     */
    private void swapValues(int i, int j) {
        int temp = stepData.get(i);
        stepData.set(i, stepData.get(j));
        stepData.set(j, temp);
    }


    /**
     * Reset the tab view with a new barchart
     */
    @Override
    public void resetButtonPressed() {
        stepData.clear();
        super.resetButtonPressed();
    }
}
