package SortingAlgorithms;

import java.util.Random;

public class QuickSort {

    private QuickSort() {}

    private interface QuickSortPivotPicker{
        public int pickPivot(int[] array,int arrayStart, int arrayEnd);
    }
    private  static QuickSortPivotPicker firstElementPicker = (a,s,e) -> a[s];
    private  static QuickSortPivotPicker randomElementPicker = (a,s,e) -> {
        Random r = new Random();
        return a[r.nextInt(s,e)];
    };

    public static int[] quickSortFEP(int[] array) {
        return genericQuickSort(array, 0, array.length, firstElementPicker);
    }

    public static int[] quickSortREP(int[] array) {
        return genericQuickSort(array, 0, array.length, randomElementPicker);
    }

    private static int[] genericQuickSort(int[] array, int start, int end, QuickSortPivotPicker picker){
        return null;
    }
}
