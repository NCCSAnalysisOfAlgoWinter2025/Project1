package sorting.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

  @Test
  void sort() {
    RadixSort radixSort = new RadixSort();
    int[] arr = {9, 8, 7, 6};
    radixSort.sort(arr);
    int[] expected = {6, 7, 8, 9};
    assertArrayEquals(expected, arr);
  }
}
