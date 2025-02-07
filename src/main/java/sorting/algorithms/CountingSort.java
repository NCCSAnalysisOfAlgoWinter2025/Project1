package sorting.algorithms;

import java.util.Arrays;
import tempresults.SortAlgorithm;

/**
 * Implements the counting sort algorithm.
 */
@SuppressWarnings({"ForLoopReplaceableByForEach", "SpellCheckingInspection"})
public class CountingSort implements SortAlgorithm  {

  /**
   * Big O (n + k), Big Omega (n + k) and Theta (n + k)
   * k represents the range of values in the array
   * Sorts input array with the countingSort algorithm
   * I wrote the code for this algorithm by following along with the
   * explanation in the geeeksforgeeks.org website. I didn't copy the
   * copy, I simply followed the graphical explanation of how the
   * algorithm works and wrote my own code.
   * One disadvantage of this algorithm is that it can only sort
   * arrays containing non-negative numbers.
   *
   * @param inputArray integer array to be sorted
   */
  @Override
  public void sort(int[] inputArray) {
    int max = Arrays.stream(inputArray).max().orElseThrow();

    int[] countArray = new int[max + 1];
    int[] outputArray = new int[inputArray.length];

    for (int i = 0; i < inputArray.length; i++) {
      countArray[inputArray[i]]++;
    }

    for (int j = 1; j <= max; j++) {
      countArray[j] = countArray[j - 1] + countArray[j];
    }

    for (int k = inputArray.length - 1; k >= 0; k--) {
      outputArray[countArray[inputArray[k]] - 1] = inputArray[k];
      countArray[inputArray[k]]--;
    }
    // copy outputArray to the inputArray object
    System.arraycopy(outputArray, 0, inputArray, 0, inputArray.length);
  }
}

