package SortingAlgorithms;

/**
 * I implemented this algorithm from memory.
 */

public class InsertionSort {

  private int[] inputArray;

  /**
   * Default constructor.
   *
   * @param inputArray array of integers to be sorted
   */
  public InsertionSort(int[] inputArray) {
    this.inputArray = inputArray;
  }

  /**
   * InsertionSort algorithm
   */
  public void insertionSort() {
    int len = this.inputArray.length;
    for (int i = 1; i < len; i++) {
      int temp = this.inputArray[i];
      for (int j = i - 1; j >= 0; j--) {
        if (this.inputArray[j] > this.inputArray[j + 1]) {
          this.inputArray[j + 1] = this.inputArray[j];
          this.inputArray[j] = temp;
          temp = this.inputArray[j];
        }
      }
    }

  }
}
