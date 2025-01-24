package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * A method wrapper containing multiple implementations of the in-place QuickSort algorithm. <br>
 * All methods will throw an exception if they are given a null array.
 */
public class QuickSort {

  private static final Random r = new Random();
  private static final QuickSortPivotPicker firstElementPicker = (a, s, e) -> s;
  private static final QuickSortPivotPicker randomElementPicker = (a, s, e) -> r.nextInt(s, e);

  private QuickSort() {}

  /**
   * QuickSort pivoting on the first element
   *
   * @param array The array you want to sort
   * @return Returns a sorted copy of the array
   */
  public static int[] quickSortFE(int[] array) {
    // make a copy of the array before passing it to the quicksort
    int[] arrayCopy = Arrays.copyOf(array, array.length);
    return genericQuickSort(arrayCopy, 0, array.length - 1, firstElementPicker);
  }

  /**
   * A generic implementation of the in-place QuickSort algorithm, that takes in a function that'll
   * decide how to pick the pivot point.
   *
   * @param a The array that will be sorted
   * @param start The index that quick sort bound will start at
   * @param end The index that quick sort bound will end at
   * @param picker The pivot picking function to be used
   * @return A reference to the sorted array (Same as 'a' param)
   */
  private static int[] genericQuickSort(int[] a, int start, int end, QuickSortPivotPicker picker) {
    // if the section we are sorting is of size 1 return
    if (start == end) {
      return a;
    }

    // if we get two elements swap them and then return
    if (start + 1 == end) {
      if (a[start] > a[end]) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
      }
      return a;
    }

    // where the pivot is located
    int pivotIndex = picker.pickPivot(a, start, end);
    int leftIndex = start;
    // pivot is stored at the end so reserve the spot
    int rightIndex = end - 1;
    // value of the pivot
    int pivot = a[pivotIndex];

    // move the pivot to the end of the bound we are sorting
    a[pivotIndex] = a[end];
    a[end] = pivot;

    int temp = 0;

    // in-place sort
    while (leftIndex <= rightIndex) {
      while (leftIndex <= rightIndex && a[leftIndex] <= pivot) {
        leftIndex++;
      }
      while (leftIndex <= rightIndex && a[rightIndex] >= pivot) {
        rightIndex--;
      }
      if (leftIndex <= rightIndex) {
        temp = a[leftIndex];
        a[leftIndex] = a[rightIndex];
        a[rightIndex] = temp;
        leftIndex++;
        rightIndex--;
      }
    }

    // at the end of the loop the left is on the first right
    a[end] = a[leftIndex];
    a[leftIndex] = pivot;

    // if every item in the array is greater than the pivot, the pivot will end up being start - 1
    // so we just max it;
    rightIndex = Math.max(rightIndex, start);

    genericQuickSort(a, start, rightIndex, firstElementPicker);
    genericQuickSort(a, rightIndex + 1, end, firstElementPicker);

    return a;
  }

  //    public static int[] quickSortREP(int[] array) {
  //        int[] arrayCopy = Arrays.copyOf(array, array.length);
  //        return genericQuickSort(array, 0, array.length - 1, randomElementPicker);
  //    }

  private interface QuickSortPivotPicker {
    int pickPivot(int[] array, int arrayStart, int arrayEnd);
  }
}
