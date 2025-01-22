package SortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

  @org.junit.jupiter.api.Test
  void insertionSort() {
    InsertionSort sort = new InsertionSort();
    int[] arr = {9,8,7,6};
    sort.insertionSort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}