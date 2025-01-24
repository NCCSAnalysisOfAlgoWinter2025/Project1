package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort() {}

    private interface QuickSortPivotPicker{
        public int pickPivot(int[] array,int arrayStart, int arrayEnd);
    }

    private static final Random r = new Random();

    private  static final QuickSortPivotPicker firstElementPicker = (a, s, e) -> s;
    private  static final QuickSortPivotPicker randomElementPicker = (a,s,e) -> {
        return r.nextInt(s,e);
    };

    public static int[] quickSortFEP(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return genericQuickSort(arrayCopy, 0, array.length - 1, firstElementPicker);
    }

//    public static int[] quickSortREP(int[] array) {
//        int[] arrayCopy = Arrays.copyOf(array, array.length);
//        return genericQuickSort(array, 0, array.length - 1, randomElementPicker);
//    }

    private static int[] genericQuickSort(int[] a, int start, int end, QuickSortPivotPicker picker){
        if(start == end){
            return a;
        }
        if(start + 1 == end){
            if(a[start] > a[end]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            return a;
        }
        int pivotIndex = picker.pickPivot(a, start, end);
        int leftIndex = start;
        int rightIndex = end - 1;
        int pivot = a[pivotIndex];
        a[pivotIndex] = a[end];
        a[end] = pivot;

        int temp = 0;

        while(leftIndex <= rightIndex){
            while (leftIndex <= rightIndex && a[leftIndex] <= pivot){
                leftIndex++;
            }
            while (leftIndex <= rightIndex && a[rightIndex] >= pivot){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                temp = a[leftIndex];
                a[leftIndex] = a[rightIndex];
                a[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }


        a[end] = a[leftIndex];
        a[leftIndex] = pivot;

        if(rightIndex < start){
            rightIndex = start;
        }

        genericQuickSort(a, start, rightIndex, firstElementPicker);
        genericQuickSort(a, rightIndex + 1, end, firstElementPicker);

        return a;
    }

}
