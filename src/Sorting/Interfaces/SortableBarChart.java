package Sorting.Interfaces;

import java.util.List;

/**
 * Class SortableBarChart
 *
 * @author Koen Hendriks
 * @version 0.1 (06-03-2017)
 */
public interface SortableBarChart {

    void step();

    void stepButtonPressed();

    void resetButtonPressed();

    void sortButtonPressed();

    void drawBarChart();

    void redrawBarChart(List<Integer> Data);
}
