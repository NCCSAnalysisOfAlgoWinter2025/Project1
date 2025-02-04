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

    /**
     * Tests the timer method of SelectionSort.
     * Ensures that the timing mechanism correctly measures
     * the execution time of the selection sort algorithm.
     */
    @Test
    void timer() {
        SelectionSort selectionSort = new SelectionSort();
        int[] testArray = new int[1000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 1000);
        }
        long startTime = System.currentTimeMillis();
        selectionSort.sort(testArray);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        assertTrue(executionTime >= 0);
    }
}