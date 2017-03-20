package Sorting.Controllers.tabControllers;

import Sorting.Controllers.BarChartController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class ${CLASS}
 *
 * @author koen
 * @version 0.1 (3/20/17)
 */
class BubbleSortControllerTest {

    private int stepOffset = 0;
    private int finished = 0;

    @Test
    void bubbleSortStep() {
        // Testing data
        ArrayList<Integer> data = new ArrayList<Integer>();

        data.add(3);
        data.add(2);

        // Size should be correct
        assert data.size() == 2;

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

        // Check the BubbleSort step to see if the values are now in order.
        assert data.get(0) == 2;
        assert data.get(1) == 3;


    }

}