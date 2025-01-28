package SortingAlgorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void quickSortFERandArray() {
        // Test on random array
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortFE(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, newSorted);


    }

    @Test
    void quickSortFEInvertedArray() {
        // Test on sorted inverted array
        int[] invertedArr = {5, 4, 3, 2, 1};
        int[] invertedSorted = QuickSort.quickSortFE(invertedArr);
        Arrays.sort(invertedArr);
        assertArrayEquals(invertedArr, invertedSorted);
    }

    @Test
    void quickSortRERandArray() {
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortRE(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, newSorted);
    }

    @Test
    void quickSortREInvertedArray() {
        int[] invertedArr = {5,4,3,2,1};
        int[] invertedSorted = QuickSort.quickSortRE(invertedArr);
        Arrays.sort(invertedArr);
        assertArrayEquals(invertedArr, invertedSorted);
    }

    @Test
    void quickSortMedianRandomArray() {
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortMedian(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, newSorted);
    }

    @Test
    void quickSortMedianInvertedArray() {
        int[] invertedArr = {5,4,3,2,1};
        int[] invertedSorted = QuickSort.quickSortMedian(invertedArr);
        Arrays.sort(invertedArr);
        assertArrayEquals(invertedArr, invertedSorted);
    }
}