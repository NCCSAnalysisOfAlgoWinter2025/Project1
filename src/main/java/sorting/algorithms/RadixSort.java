package sorting.algorithms;

import tempresults.SortAlgorithm;

/**
 * This class is in charge of storing the Radix Sort algorithm and all of its necessary helper
 * methods.
 */
@SuppressWarnings("ManualArrayCopy")
public class RadixSort implements SortAlgorithm {

  /**
   * This method prepares the input integer array for the sorting process. Once the input array
   * has been separated into its applicable negative and positive components, the components are
   * then passed as arguments for the radixSortAlgorithm method. Once sorted they are then merged
   * into the original array such that the entire array is then sorted.
   *
   * @param arr The array to prepare and sort.
   */
  @Override
  public void sort(int[] arr) {
    int[][] negAndPosArrays = splitArr(arr);
    int universalIdx = 0;

    if (negAndPosArrays[0] != null) { // sorts negative values, if present
      int negArrLength = negAndPosArrays[0].length;
      for (int i = 0; i < negArrLength; i++) {
        // (for sorting) temporarily transforms values from negative to positive
        negAndPosArrays[0][i] *= -1;
      }
      radixSortAlgorithm(negAndPosArrays[0]); // uses radix sort

      // transforms sorted values back to negative and reverses their order to
      // maintain ascending pattern
      int[] temp = new int[negArrLength];
      for (int i = negArrLength - 1; i >= 0; i--) {
        temp[negArrLength - i - 1] = negAndPosArrays[0][i] * -1;
      }
      for (int i = 0; i < negArrLength; i++) {
        negAndPosArrays[0][i] = temp[i];
      }

      // merges sorted negative portion into original array
      for (int i = 0; i < negArrLength; i++) {
        arr[universalIdx] = negAndPosArrays[0][i];
        universalIdx++;
      }
    }

    if (negAndPosArrays[1] != null) { // sorts positive values, if present
      radixSortAlgorithm(negAndPosArrays[1]); // uses radix sort
      // merges sorted positive portion into original array
      for (int i = 0; i < negAndPosArrays[1].length; i++) {
        arr[universalIdx] = negAndPosArrays[1][i];
        universalIdx++;
      }
    }
  }

  /**
   * An implementation of the Radix Sort algorithm. This algorithm works by conducting counting sort
   * in iterations based on the digits of the values in an integer array and the digits' placement
   * within those integers (e.g. ones, tens, or hundreds place). Sorts the values of the array in
   * ascending order.
   *
   * @param arr The array to sort.
   */
  private void radixSortAlgorithm(int[] arr) {
    int max = findArrMax(arr);
    for (int divisor = 1; max / divisor > 0; divisor *= 10) {
      countingSort(arr, divisor);
    }
  }

  /**
   * A version of the counting sort algorithm to be used as a helper method for the
   * radixSortAlgorithm method. Sorts the values of an integer array in ascending order based on
   * particular digits.
   *
   * @param arr The array to sort.
   * @param div The value to divide an integer by, used with modulo to put focus on certain digits.
   */
  private void countingSort(int[] arr, int div) {
    int[] countArr = new int[10]; // size 10 since digits range from 0 to 9

    for (int value : arr) {
      countArr[(value / div) % 10]++;
    }

    for (int i = 1; i < countArr.length; i++) {
      countArr[i] += countArr[i - 1];
    }

    int[] newArr = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int current = arr[i];
      int pos = countArr[(current / div) % 10] - 1;
      newArr[pos] = current;
      countArr[(current / div) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = newArr[i];
    }
  }

  /**
   * Takes an integer array and splits it into two arrays. The first array stores all the negative
   * values while the second array stores all the positive values. If the input array has no
   * negative values or no positive values, then the respective array will be null.
   *
   * @param arr The array to be split.
   * @return 2D array
   */
  private int[][] splitArr(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty.");
    } else {
      int posCount = 0;
      int negCount = 0;

      for (int value : arr) {
        if (value >= 0) {
          posCount++;
        } else {
          negCount++;
        }
      }

      int[] posArr = (posCount > 0) ? new int[posCount] : null;
      int[] negArr = (negCount > 0) ? new int[negCount] : null;

      if (posArr != null) {
        int idx = 0;
        for (int value : arr) {
          if (value >= 0) {
            posArr[idx] = value;
            idx++;
          }
        }
      }
      if (negArr != null) {
        int idx = 0;
        for (int value : arr) {
          if (value < 0) {
            negArr[idx] = value;
            idx++;
          }
        }
      }

      return new int[][] {negArr, posArr};
    }
  }

  /**
   * Finds the largest value in an integer array.
   *
   * @param arr The array to scan.
   * @return The largest value in the array.
   */
  private int findArrMax(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be null or empty.");
    } else {
      int max = arr[0];
      for (int value : arr) {
        if (value > max) {
          max = value;
        }
      }
      return max;
    }
  }
}
