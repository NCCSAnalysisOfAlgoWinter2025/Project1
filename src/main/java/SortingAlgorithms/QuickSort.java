package SortingAlgorithms;


import java.util.Random;

/**
 * A method wrapper containing multiple implementations of the in-place QuickSort algorithm. <br>
 * All methods will throw an exception if they are given a null array.
 */
public class QuickSort {
//  private static final QuickSortPivotPicker firstElementPicker = (a, s, e) -> s;
  /* Instance of random is made here for two reasons: I only need to manage one instance,
  creating a new random every time I want to get a new random number is dumb */
//  private static final Random r = new Random();
//  private static final QuickSortPivotPicker randomElementPicker = (a, s, e) -> r.nextInt(s, e);
  // small memory optimization
  private static int temp;


  private QuickSort() {}


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

  public static int[] genericQuickSort(int[] a, int start, int end, QuickSortPivotPicker picker) {

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

    genericQuickSort(a, start, rightIndex, picker);
    genericQuickSort(a, rightIndex + 1, end, picker);

    return a;
  }

  @FunctionalInterface
  public interface QuickSortPivotPicker {
    int pickPivot(int[] array, int arrayStart, int arrayEnd);
  }
}
