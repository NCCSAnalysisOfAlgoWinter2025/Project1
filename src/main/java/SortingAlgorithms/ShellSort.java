package SortingAlgorithms;

import Results.SortAlgorithm;
import ArrayCreator.ArrayCreator;

public class ShellSort implements SortAlgorithm {
    /**
     * Implements shell sort algorithm.
     * Time Complexity: O(n^2) worst case, can be O(n log n) depending on gap sequence
     * Space Complexity: O(1)
     *
     * @param arr Array to be sorted
     */
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
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