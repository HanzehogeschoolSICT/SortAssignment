package Sorting.Controllers;

import javafx.scene.chart.BarChart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class ${CLASS}
 *
 * @author koen
 * @version 0.1 (3/20/17)
 */
class BarChartControllerTest {

    @Test
    void getRandomArrayList() {
        int size = 10;
        ArrayList<Integer> array = BarChartController.getRandomArrayList(size);

        // Check for correct given size
        assert array.size() == size;

        // Check for duplicates
        ArrayList<Integer> dubs = new ArrayList<Integer>();
        for (Integer i : array) {
            assert !dubs.contains(i);
            dubs.add(i);
        }

    }

}