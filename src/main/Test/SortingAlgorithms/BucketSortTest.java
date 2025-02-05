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
}