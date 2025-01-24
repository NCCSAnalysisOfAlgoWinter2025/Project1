package SortingAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class QuickSortTest {

    @Test
    void quickSortFEP() {
        Random r = new Random();
        ArrayList<Integer> randArrayList = new ArrayList<>();
        for (int i = 0; i < r.nextInt(1, 3200000); i++) {
            randArrayList.add(r.nextInt());
        }
        Integer[] al = new Integer[randArrayList.size()];
        randArrayList.toArray(al);

        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
        int[] newSorted = QuickSort.quickSortFEP(arr);
        Arrays.sort(arr);
        assertArrayEquals(newSorted, arr);

        int[] invertedArr = {5,4,3,2,1};
        int[] invertedSorted = QuickSort.quickSortFEP(invertedArr);
        Arrays.sort(invertedArr);
        assertArrayEquals(invertedSorted, invertedArr);
    }

//    @Test
//    void quickSortREP() {
//        Random r = new Random();
//        ArrayList<Integer> randArrayList = new ArrayList<>();
//        for (int i = 0; i < r.nextInt(1, 100); i++) {
//            randArrayList.add(r.nextInt());
//        }
//        Integer[] al = new Integer[randArrayList.size()];
//        randArrayList.toArray(al);
//
//        int[] arr = Arrays.stream(al).mapToInt(Integer::intValue).toArray();
//        int[] newSorted = QuickSort.quickSortREP(arr);
//        Arrays.sort(arr);
//        assertArrayEquals(newSorted, arr);
//
//        int[] invertedArr = {5,4,3,2,1};
//        int[] invertedSorted = QuickSort.quickSortREP(invertedArr);
//        Arrays.sort(invertedArr);
//        assertArrayEquals(invertedSorted, invertedArr);
//    }
}