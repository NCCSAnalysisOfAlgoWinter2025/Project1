package Results;

import ArrayCreator.ArrayCreator;

public interface SortAlgorithm {
    void sort(int[] array);

    /**
     * Runs the algorithm labeled currentSort and times it
     * @param inputArray array to be sorted
     * @return time in milliseconds(ms) it took for the array to be sorted
     */
    long timer(ArrayCreator inputArray);
}