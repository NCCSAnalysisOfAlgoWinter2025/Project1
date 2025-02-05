package SortingAlgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

  @Test
  void sort() {
    BubbleSort bubbleSort = new BubbleSort();
    int[] arr = {9, 8, 7, 6};
    bubbleSort.sort(arr);
    int[] expected = {6, 7, 8, 9};
    assertArrayEquals(expected, arr);
  }
}
