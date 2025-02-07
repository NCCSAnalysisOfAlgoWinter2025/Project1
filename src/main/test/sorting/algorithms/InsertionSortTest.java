package sorting.algorithms;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

  @org.junit.jupiter.api.Test
  void sort() {
    InsertionSort insertionSort = new InsertionSort();
    int[] arr = {9,8,7,6};
    insertionSort.sort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}