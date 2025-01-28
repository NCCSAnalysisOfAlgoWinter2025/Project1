// Selection Sort Implementation


public class SelectionSort implements SortingAlgorithm {
    /**
     * Implements selection sort algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr Array to be sorted
     * @return Time taken in microseconds
     */
    @Override
    public long sort(int[] arr) {
        long startTime = System.nanoTime();

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

        return (System.nanoTime() - startTime) / 1000; // Convert to microseconds
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}