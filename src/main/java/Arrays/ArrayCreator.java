package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayCreator {

    private int size = 0;
    private int[] array;

    public ArrayCreator(int size){
        this.size = size;
        this.array = new int[size];
        this.array = this.randomArray();
    }

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

    public int[] orderedArray(){
        // I'm creating a copy so I don't change the order of the original array
        int[] newArray = Arrays.copyOfRange(this.array, 0, this.size);
        Arrays.sort(newArray);
        return newArray;
    }

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
