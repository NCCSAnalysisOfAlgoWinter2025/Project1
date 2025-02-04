package SortingAlgorithms;

import java.util.Arrays;

public class QuickSortMedian {
    private static int temp;
    private static final QuickSort.QuickSortPivotPicker medianOfThreePicker =
            (a, s, e) -> {

                // How many elements to pick out from start, middle, and end
                int numOfElemsToGrabForMedian = 5;

                // Go to 1 if we literally can't grab enough elements
                if ((e + 1 - s) / (3.0 * numOfElemsToGrabForMedian) < 1.0) {
                    numOfElemsToGrabForMedian = 1;
                }

        /* Parallel arrays, the littleArrIndex will be sorted according to littleArrVals,
        so we can later return an index not a value */
                int[] littleArrVals = new int[3 * numOfElemsToGrabForMedian];
                int[] littleArrIndex = new int[3 * numOfElemsToGrabForMedian];

                // populate
                for (int i = 0; i < numOfElemsToGrabForMedian; i++) {
                    // from start going to the right
                    littleArrVals[i] = a[i + s];
                    littleArrIndex[i] = i + s;

                    // from middle going to the right
                    littleArrVals[numOfElemsToGrabForMedian + i] =
                            a[(e - s) / 2 - (int) Math.ceil(numOfElemsToGrabForMedian / 2.0) + i + s];
                    littleArrIndex[numOfElemsToGrabForMedian + i] =
                            (e - s) / 2 - (int) Math.ceil(numOfElemsToGrabForMedian / 2.0) + i + s;

                    // from end going to the left
                    littleArrVals[2 * numOfElemsToGrabForMedian + i] = a[e - i];
                    littleArrIndex[2 * numOfElemsToGrabForMedian + i] = e - i;
                }

                // Mega cool (unoptimized) bubble sort
                boolean hasNotSort = false;
                while (!hasNotSort) {
                    hasNotSort = true;
                    for (int i = 0; i < littleArrVals.length - 1; i++) {
                        if (littleArrVals[i] > littleArrVals[i + 1]) {
                            temp = littleArrVals[i];
                            littleArrVals[i] = littleArrVals[i + 1];
                            littleArrVals[i + 1] = temp;

                            temp = littleArrIndex[i];
                            littleArrIndex[i] = littleArrIndex[i + 1];
                            littleArrIndex[i + 1] = temp;
                            hasNotSort = false;
                        }
                    }
                }

                return littleArrIndex[Math.abs((littleArrIndex.length - 1) / 2)];
            };

    /**
     * QuickSort pivoting on a median element.
     *
     * @param array The array you want to sort
     * @return Returns a sorted copy of the array
     */
    public static int[] sort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return QuickSort.genericQuickSort(arrayCopy, 0, array.length - 1, medianOfThreePicker);
    }
}
