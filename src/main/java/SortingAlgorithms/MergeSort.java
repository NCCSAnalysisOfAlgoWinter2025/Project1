package SortingAlgorithms;

/**
 * The code below is from "Coding with John" youtube channel. I made a couple changes such
 * as the variable names in merge from i,j,k to leftPos,rightPos and arrPos so they are
 * more descriptive.
 */

public class MergeSort {

    /**
     * Default constructor.
     * @param inputArray
     */
    public MergeSort(int[] inputArray){
    }

    /**
     * Sorts an int array with the MergeSort method. Uses the Merge
     * helper method below for merging arrays.
     * @param inputArray
     */
    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    /**
     * Helper method for MergeSort method that merges the arrays created
     * back together.
     * @param inputArray
     * @param leftHalf
     * @param rightHalf
     */
    private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftPos = 0, rightPos = 0, arrPos = 0;

        while (leftPos < leftSize && rightPos < rightSize) {
            if (leftHalf[leftPos] <= rightHalf[rightPos]) {
                inputArray[arrPos] = leftHalf[leftPos];
                leftPos++;
            }
            else {
                inputArray[arrPos] = rightHalf[rightPos];
                rightPos++;
            }
            arrPos++;
        }

        while (leftPos < leftSize) {
            inputArray[arrPos] = leftHalf[leftPos];
            leftPos++;
            arrPos++;
        }

        while (rightPos < rightSize) {
            inputArray[arrPos] = rightHalf[rightPos];
            rightPos++;
            arrPos++;
        }

    }
}