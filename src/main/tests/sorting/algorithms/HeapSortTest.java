package sorting.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

  @Test
  void sort() {
    HeapSort heapSort = new HeapSort();
    int[] arr = {9, 8, 7, 6};
    heapSort.sort(arr);
    int[] expected = {6, 7, 8, 9};
    assertArrayEquals(expected, arr);
  }
}
