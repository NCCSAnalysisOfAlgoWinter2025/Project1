package SortingAlgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    /**
     * Tests the sort method of SelectionSort.
     * Verifies that the algorithm correctly sorts an array
     * in ascending order through selection sort.
     */
    @Test
    void sort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        selectionSort.sort(testArray);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, testArray);
    }
}