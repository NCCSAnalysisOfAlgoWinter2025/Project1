package SortingAlgorithms;

/**
 * This class is in charge of storing the Heap Sort algorithm.
 */
public class HeapSort {

  /**
   * Transforms an integer array such that it represents a heap data structure, and iteratively calls heapify on the
   * heap in decrements so that the largest value is always at the end of each newly unsorted portion. This results in
   * an integer array that is sorted in ascending order.
   *
   * @param arr The array to sort.
   */
  public static void sort(int[] arr) {
    int temp;
    buildHeap(arr, arr.length);

    for (int i = arr.length - 1; i >= 0; i--) {
      temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
    }
  }

  /**
   * Helper method that ensures that a heap follows a Max Heap structure, where the root/first value is larger
   * than all the other values that follow.
   *
   * @param arr An array representing/mimicking a heap.
   * @param heapSize The size of the heap, in this case the length of the array.
   * @param idx The index of the value to heapify (replace with the largest value, if found), usually the first index.
   */
  private static void heapify(int[] arr, int heapSize, int idx) {
    int largest = idx;
    int temp;
    int left = idx * 2 + 1;
    int right = idx * 2 + 2;

    // determines the largest child
    if (left <= heapSize - 1 && arr[largest] < arr[left]) {
      largest = left;
    }
    if (right <= heapSize - 1 && arr[largest] < arr[right]) {
      largest = right;
    }

    // exchanges nodes with the largest child, if found
    if (largest != idx) {
      temp = arr[idx];
      arr[idx] = arr[largest];
      arr[largest] = temp;
      heapify(arr, heapSize, largest); // recursive call to maintain max heap structure
    }
  }

  /**
   * Transforms an integer array such that it represents a heap data structure.
   *
   * @param arr The array to transform.
   * @param heapSize The size of the heap, usually the length of the array.
   */
  private static void buildHeap(int[] arr, int heapSize) {
    for (int i = heapSize / 2 - 1; i >= 0; i--) {
      heapify(arr, heapSize, i);
    }
  }
}
