package SortingAlgorithms;

import Results.SortAlgorithm;

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
}