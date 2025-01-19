package Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * This class provides functionality for generating arrays of varying sizes.
 * It allows for the creation of several derived arrays from the original,
 * including ordered, reversed, 50% ordered, and 75% ordered arrays.
 */
public class ArrayCreator {

    private int size = 0;
    private int[] array;

    /**
     * Default constructor for creating an array of the size passed by
     * the object created.
     * @param size
     */
    public ArrayCreator(int size){
        this.size = size;
        this.array = new int[size];
        this.array = this.randomArray();
    }

    /**
     * Builds a random array of numbers between zero and 40,000.
     * @return int[]
     */
    private int[] randomArray(){
        Random rand = new Random();

        for(int i = 0;i < this.size;i++){
            this.array[i] = rand.nextInt(40000);
        }
        return this.array;
    }

    public int[] array(){
        return this.array;
    }

    /**
     * Takes the array created by the randomArray() method and sorts it.
     * @return int[]
     */
    public int[] orderedArray(){
        // I'm creating a copy so I don't change the order of the original array
        int[] newArray = Arrays.copyOfRange(this.array, 0, this.size);
        Arrays.sort(newArray);
        return newArray;
    }

    /**
     * Takes the array created by the randomArray() sorts it in reversed order.
     * @return int[]
     */
    public int[] reversedArray(){
        int[] orderedArray = this.orderedArray();
        int[] newArray = Arrays.copyOfRange(orderedArray, 0, this.size);
        int newArraySize = this.size - 1;

        for(int i = 0;i < this.size;i++){
            newArray[newArraySize] = orderedArray[i];
            newArraySize--;
        }

        return newArray;
    }

    /**
     * Takes the array created by the randomArray() and sorts the first half
     * and leaves the second half as is.
     * @return int[]
     */
    public int[] fiftyPercentOrdered(){
        int[] newArray = new int[this.size];
        int[] firstHalf = Arrays.copyOfRange(this.array, 0, this.size / 2);

        Arrays.sort(firstHalf);

        for(int i = 0;i < firstHalf.length;i++){
            newArray[i] = firstHalf[i];
        }

        for(int i = firstHalf.length;i < this.size;i++){
            newArray[i] = this.array[i];
        }

        return newArray;
    }

    /**
     * Takes the array created by the randomArray() and sorts the first 75%
     * and leaves the last 25% as is.
     * @return int[]
     */
    public int[] seventyFivePercentOrdered(){
        int[] newArray = new int[this.size];
        int seventyFivePercent = (int)(this.size * 0.75);
        int[] firstHalf = Arrays.copyOfRange(this.array, 0, seventyFivePercent);

        Arrays.sort(firstHalf);

        for(int i = 0;i < firstHalf.length;i++){
            newArray[i] = firstHalf[i];
        }

        for(int i = firstHalf.length;i < this.size;i++){
            newArray[i] = this.array[i];
        }

        return newArray;
    }
}
