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

    public void initialize(){
        super.setAnchorPane(bubbleSortAnchor);
        super.setSpeedTextField(speedTextField);
        super.initialize();
    }

    @Override
    public List<Integer> step() {
        List<Integer> data = BarChartController.getSeriesData(super.bc);

        if(finished >= data.size()){
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
        this.stepOffset = 0;
        this.finished = 0;
        super.resetButtonPressed();
    }
}
