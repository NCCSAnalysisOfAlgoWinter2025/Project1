package SortingAlgorithms;

import java.util.Arrays;

public class QuickSortFE
    /**
     * QuickSort pivoting on a median element.
     *
     * @param array The array you want to sort
     * @return Returns a sorted copy of the array
     */{
    public static int[] sort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return QuickSort.genericQuickSort(arrayCopy, 0, array.length - 1, firstElementPicker);
    }
    private static final QuickSort.QuickSortPivotPicker firstElementPicker = (a, s, e) -> s;
}
