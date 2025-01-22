package SortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

  @Test
  void countingSort() {
    CountingSort sort = new CountingSort();
    int[] arr = {9,8,7,6};
    sort.countingSort(arr);
    int[] expected = {6,7,8,9};
    assertArrayEquals(expected, arr);
  }
}