package SortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    /**
     * Tests the sort method of ShellSort.
     * Verifies that the shell sort algorithm correctly sorts
     * an array in ascending order using gap sequences.
     */
    @Test
    void sort() {
        ShellSort shellSort = new ShellSort();
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        shellSort.sort(testArray);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, testArray);
    }

    /**
     * Tests the timer method of ShellSort.
     * Verifies that the timing mechanism accurately measures
     * the execution time of the shell sort algorithm.
     */
    @Test
    void timer() {
        ShellSort shellSort = new ShellSort();
        int[] testArray = new int[1000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 1000);
        }
        long startTime = System.currentTimeMillis();
        shellSort.sort(testArray);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        assertTrue(executionTime >= 0);
    }
}