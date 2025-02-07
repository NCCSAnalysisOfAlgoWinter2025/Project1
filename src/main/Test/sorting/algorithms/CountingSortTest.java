package sorting.algorithms;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

  @org.junit.jupiter.api.Test
  void sort() {
    CountingSort countingSort = new CountingSort();
    int[] arr = {9,8,7,6};
    countingSort.sort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}