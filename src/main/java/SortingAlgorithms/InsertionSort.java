package SortingAlgorithms;

/**
 * I implemented this algorithm from memory.
 */

public class InsertionSort{

  /**
   * Big O (n^2), Big Omega (n) and Theta (n^2)
   *
   * InsertionSort algorithm
   *
   * @param inputArray  integer array to be sorted
   */
  public static void insertionSort(int[] inputArray) {
    int len = inputArray.length;
    for (int i = 1; i < len; i++) {
      int temp = inputArray[i];
      for (int j = i - 1; j >= 0; j--) {
        if (inputArray[j] > inputArray[j + 1]) {
          inputArray[j + 1] = inputArray[j];
          inputArray[j] = temp;
          temp = inputArray[j];
        }
      }
    }

  }
}
