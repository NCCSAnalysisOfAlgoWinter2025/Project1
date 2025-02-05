package SortingAlgorithms;

import Results.SortAlgorithm;

/**
 * This class is in charge of storing the Bubble Sort algorithm.
 */
public class BubbleSort implements SortAlgorithm {

  /**
   * An implementation of the Bubble Sort algorithm. In this algorithm, the largest value of an integer array is
   * moved to the end of the array in an iteration. The algorithm goes through several iterations, and in each one the
   * new largest value is moved to the end of the unsorted portion. Values are sorted in ascending order.
   *
   * @param arr The array to sort.
   */
  @Override
  public void sort(int[] arr) {
    for (int passIdx = 0; passIdx < arr.length - 1; passIdx++) {
      boolean swapped = false;
      for (int chkIdx = 0; chkIdx < arr.length - passIdx - 1; chkIdx++) {
        if (arr[chkIdx] > arr[chkIdx + 1]) {
          int temp = arr[chkIdx];
          arr[chkIdx] = arr[chkIdx + 1];
          arr[chkIdx + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }
}
