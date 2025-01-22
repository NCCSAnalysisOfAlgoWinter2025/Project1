package SortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

  @org.junit.jupiter.api.Test
  void mergeSort() {
    MergeSort sort = new MergeSort();
    int[] arr = {9,8,7,6};
    sort.mergeSort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}