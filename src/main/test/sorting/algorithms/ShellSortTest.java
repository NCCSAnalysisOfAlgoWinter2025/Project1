package sorting.algorithms;

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
}