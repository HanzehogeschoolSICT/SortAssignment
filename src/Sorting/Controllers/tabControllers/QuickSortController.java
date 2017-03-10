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
 * @version 0.1 (02-03-2017)
 */
public class QuickSortController extends AbstractSortController {

    @FXML
    private AnchorPane quickSortAnchor;

    @FXML
    private TextField speedTextField;

    private List<Integer> tempData;

    public void initialize(){
        // Tell the AbstractSortController which pane and textfield we have.
        super.setAnchorPane(quickSortAnchor);
        super.setSpeedTextField(speedTextField);

        // Initialize the AbstractSortController to create and draw the BarChart.
        super.initialize();
    }

    @Override
    public List<Integer> step() {
        final List<Integer> data = super.getSerieData();

        return data;
    }

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
                swap(low, high);
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

    private void swap(int i, int j) {
        int temp = tempData.get(i);
        tempData.set(i, tempData.get(j));
        tempData.set(j, temp);
    }


    /**
     * Reset the tab view with a new barchart
     */
    @Override
    public void resetButtonPressed() {

        // TODO add fields to clear

        super.resetButtonPressed();
    }
}
