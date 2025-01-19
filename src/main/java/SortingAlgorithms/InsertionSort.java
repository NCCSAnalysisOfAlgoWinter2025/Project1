package SortingAlgorithms;

/**
 * I implemented this algorithm from memory.
 */

public class InsertionSort {
    /**
     * Defualt constructor.
     * @param inputArray
     */
    public InsertionSort(int[] inputArray){
    }

    /**
     * InsertionSort algorithm
     * @param inputArray
     */
    public static void insertionSort(int[] inputArray){
        int len = inputArray.length;
        for(int i = 1;i < len;i++){
            int temp = inputArray[i];
            for(int j = i - 1;j >= 0;j--){
                if(inputArray[j] > inputArray[j + 1]){
                    inputArray[j + 1] = inputArray[j];
                    inputArray[j] = temp;
                    temp = inputArray[j];
                }
            }
        }

    }
}
