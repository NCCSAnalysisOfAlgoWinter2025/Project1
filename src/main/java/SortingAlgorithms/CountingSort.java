package SortingAlgorithms;

import java.util.Arrays;

public class CountingSort {

  /**
   * Big O (n + k), Big Omega (n + k) and Theta (n + k)
   *
   * Sorts input array with the countingSort algorithm
   *
   * I wrote the code for this algorithm by following along with the
   * explanation in the geeeksforgeeks.org website. I didn't copy the
   * copy, I simply followed the graphical explanation of how the
   * algorithm works and wrote my own code.
   *
   * @param inputArray integer array to be sorted
   */

  public static void countingSort(int[] inputArray){
    int max = Arrays.stream(inputArray).max().orElseThrow();

    int[] countArray = new int[max + 1];
    int[] outputArray = new int[inputArray.length];

    for(int i = 0;i < inputArray.length;i++){
      countArray[inputArray[i]]++;
    }

    for(int j = 1;j <= max;j++){
      countArray[j] = countArray[j - 1] + countArray[j];
    }

    for(int k = inputArray.length - 1;k >= 0;k--){
      outputArray[countArray[inputArray[k]] - 1] = inputArray[k];
      countArray[inputArray[k]]--;
    }
    // copy outputArray to the inputArray object
    System.arraycopy(outputArray, 0, inputArray, 0, inputArray.length);
  }
}
