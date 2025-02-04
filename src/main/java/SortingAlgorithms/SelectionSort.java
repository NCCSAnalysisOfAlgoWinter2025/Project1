package SortingAlgorithms;

import Results.SortAlgorithm;
import ArrayCreator.ArrayCreator;

public class SelectionSort implements SortAlgorithm {
    /**
     * Implements selection sort algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr Array to be sorted
     */
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap elements
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Times the sorting of an array
     * @param inputArray array to be sorted
     * @return time in milliseconds(ms) it took for the array to be sorted
     */
    @Override
    public long timer(ArrayCreator inputArray) {
        // Use the timer implementation from your ChartCreator class
        long startTime = System.currentTimeMillis();
        int[] arr = new int[inputArray.getSize()]; // Assuming getSize() exists in ArrayCreator
        sort(arr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}