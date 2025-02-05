package SortingAlgorithms;

import Results.SortAlgorithm;
/**
 * The code below is from "Coding with John" YouTube channel. I made a couple changes such
 * as the variable names in merge from i,j,k to leftPos,rightPos and arrPos so they are
 * more descriptive. I chose this as it is how I learned this algorithm and found his
 * implementation less confusing than others I had found.
 */

public class MergeSort implements SortAlgorithm {

  /**
   * The Big O, Big Omega and Theta for merge sort is O(n log n)
   *
   * Sorts an int array with the MergeSort method. Uses the Merge
   * helper method below for merging arrays.
   *
   * @param inputArray the input array of integers to be sorted
   */
  @Override
  public void sort(int[] inputArray) {
    int inputLength = inputArray.length;

    if (inputLength < 2) {
      return;
    }

    int midIndex = inputLength / 2;
    int[] leftHalf = new int[midIndex];
    int[] rightHalf = new int[inputLength - midIndex];

    /*
    This is code that the code style checker wrote over what I had originally
    written, it does the same thing that the two for loops I wrote, I decided to
    leave it as is
     */
    System.arraycopy(inputArray, 0, leftHalf, 0, midIndex);
    System.arraycopy(inputArray, midIndex, rightHalf, 0, inputLength - midIndex);

    sort(leftHalf);
    sort(rightHalf);

    merge(inputArray, leftHalf, rightHalf);
  }

  /**
   * Helper method for MergeSort method that merges the arrays created
   * back together.
   *
   * @param inputArray the input array of arrays to be merged
   * @param leftHalf the left half of the input array to merged
   * @param rightHalf the right half of the input array to be merged
   */
  private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    int leftPos = 0, rightPos = 0, arrPos = 0;

    while (leftPos < leftSize && rightPos < rightSize) {
      if (leftHalf[leftPos] <= rightHalf[rightPos]) {
        inputArray[arrPos] = leftHalf[leftPos];
        leftPos++;
      } else {
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