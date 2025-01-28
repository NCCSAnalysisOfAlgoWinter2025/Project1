// Shell Sort Implementation


public class ShellSort implements SortingAlgorithm {
    /**
     * Implements shell sort algorithm.
     * Time Complexity: O(n^2) worst case, can be O(n log n) depending on gap sequence
     * Space Complexity: O(1)
     *
     * @param arr Array to be sorted
     * @return Time taken in microseconds
     */
    @Override
    public long sort(int[] arr) {
        long startTime = System.nanoTime();

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

        return (System.nanoTime() - startTime) / 1000;
    }

    @Override
    public String getName() {
        return "Shell Sort";
    }
}