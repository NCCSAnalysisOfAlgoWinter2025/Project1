package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSortRE {
    /**
     * QuickSort pivoting on a random element.
     *
     * @param array The array you want to sort
     * @return Returns a sorted copy of the array
     */
    public static int[] sort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return QuickSort.genericQuickSort(arrayCopy, 0, array.length - 1, randomElementPicker);
    }
    private static final Random r = new Random();
    private static final QuickSort.QuickSortPivotPicker randomElementPicker = (_, s, e) -> r.nextInt(s, e);
}
