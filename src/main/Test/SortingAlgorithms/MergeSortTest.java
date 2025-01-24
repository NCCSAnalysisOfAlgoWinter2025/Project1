package SortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

  /*
  The two lines commented out below are from before changing the mergeSort
  method to being static. Line 16 is the substitution for those two lines
   */
  @org.junit.jupiter.api.Test
  void mergeSort() {
//    MergeSort sort = new MergeSort();
    int[] arr = {9,8,7,6};
//    sort.mergeSort(arr);
    MergeSort.mergeSort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}