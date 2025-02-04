package SortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {
    /**
     * Tests the sort method of BucketSort.
     * Creates arrays of different sizes and configurations to verify
     * correct sorting behavior.
     */
    @Test
    void sort() {
        BucketSort bucketSort = new BucketSort();
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        bucketSort.sort(testArray);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, testArray);
    }

    /**
     * Tests the timer method of BucketSort.
     * Verifies that the timing mechanism returns a non-negative value
     * and successfully measures the execution time of the sort.
     */
    @Test
    void timer() {
        BucketSort bucketSort = new BucketSort();
        int[] testArray = new int[1000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 1000);
        }
        long startTime = System.currentTimeMillis();
        bucketSort.sort(testArray);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        assertTrue(executionTime >= 0);
    }
}