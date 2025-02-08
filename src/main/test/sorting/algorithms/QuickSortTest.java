package sorting.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void quickSortFirstElRandArray() {
        // Test on random array
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortFirstEl(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, newSorted);


    }

    @Test
    void quickSortFirstElInvertedArray() {
        // Test on sorted inverted array
        int[] invertedArr = {5, 4, 3, 2, 1};
        int[] invertedSorted = QuickSort.quickSortFirstEl(invertedArr);
        Arrays.sort(invertedArr);
        assertArrayEquals(invertedArr, invertedSorted);
    }

    @Test
    void quickSortRandElRandArray() {
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortRandEl(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, newSorted);
    }

    @Test
    void quickSortRandElInvertedArray() {
        int[] invertedArr = {5,4,3,2,1};
        int[] invertedSorted = QuickSort.quickSortRandEl(invertedArr);
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