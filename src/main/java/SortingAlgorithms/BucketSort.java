package SortingAlgorithms;
// Bucket Sort Implementation


import java.util.ArrayList;
import java.util.Collections;

public class BucketSort{
    private BucketSort(){}
    /**
     * Implements bucket sort algorithm.
     * Time Complexity: O(n + k) average case, O(n^2) worst case
     * Space Complexity: O(n + k)
     *
     * @param arr Array to be sorted
     * @return Time taken in microseconds
     */
    public static long sort(int[] arr) {
        long startTime = System.nanoTime();

        // Handle empty arrays and single-element arrays
        if (arr.length <= 1) {
            return (System.nanoTime() - startTime) / 1000;
        }

        // Find min and max values
        int maxVal = arr[0], minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) maxVal = arr[i];
            if (arr[i] < minVal) minVal = arr[i];
        }

        // If all elements are the same, no sorting needed
        if (maxVal == minVal) {
            return (System.nanoTime() - startTime) / 1000;
        }

        // Number of buckets, using square root of array length
        int bucketCount = Math.max(2, (int) Math.sqrt(arr.length));
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute input array values into buckets
        double range = maxVal - minVal + 1.0; // Add 1 to avoid division by zero for consecutive integers
        for (int value : arr) {
            int bucketIndex = (int) (((value - minVal) * (bucketCount - 1)) / range);
            buckets.get(bucketIndex).add(value);
        }

        // Sort buckets and concatenate
        int currentIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[currentIndex++] = value;
            }
        }

        return (System.nanoTime() - startTime) / 1000;
    }

    public static String getName() {
        return "Bucket Sort";
    }
}