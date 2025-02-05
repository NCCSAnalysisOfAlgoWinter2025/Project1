package ArrayCreator;

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
   *
   * @param size of the array being created.
   */
  public ArrayCreator(int size) {
    this.size = size;
    this.array = new int[size];
    this.array = this.randomArray();
  }

  public int getSize(){
    return this.size;
  }

  /**
   * Builds a random array of numbers between zero and 40,000
   *
   * @return An array of random integers of the specified size
   */
  private int[] randomArray() {
    Random rand = new Random();

    for (int i = 0; i < this.size; i++) {
      this.array[i] = rand.nextInt(40000);
    }
    return this.array;
  }

  /**
   * Returns array created in randomArray method
   *
   * @return Array of random integers
   */
  public int[] array() {
    return this.array;
  }

  /**
   * Takes the array created by the randomArray() method and sorts it
   *
   * @return a
   */
  public int[] orderedArray() {
    // I'm creating a copy so I don't change the order of the original array
    int[] newArray = Arrays.copyOfRange(this.array, 0, this.size);
    Arrays.sort(newArray);
    return newArray;
  }

  /**
   * Reversed array method
   *
   * @return asdf
   */
  public int[] reversedArray() {
    int[] orderedArray = this.orderedArray();
    int[] newArray = Arrays.copyOfRange(orderedArray, 0, this.size);
    int newArraySize = this.size - 1;

    for (int i = 0; i < this.size; i++) {
      newArray[newArraySize] = orderedArray[i];
      newArraySize--;
    }
    return newArray;
  }

  /**
   * Takes the array created by the randomArray() and sorts the first half
   * and leaves the second half as is.
   *
   * @return Array with the first 50% ordered
   */
  public int[] fiftyPercentOrdered() {
    int[] newArray = new int[this.size];
    int[] firstHalf = Arrays.copyOfRange(this.array, 0, this.size / 2);

    Arrays.sort(firstHalf);
    System.arraycopy(firstHalf, 0, newArray, 0, firstHalf.length);

    if (this.size - firstHalf.length >= 0)
      System.arraycopy(this.array, firstHalf.length, newArray, firstHalf.length, this.size - firstHalf.length);

    return newArray;
  }

  /**
   * Takes the array created by the randomArray() and sorts the first 75%
   * and leaves the last 25% as is.
   *
   * @return Array with the first 75% ordered
   */
  @SuppressWarnings({"checkstyle:RightCurly", "checkstyle:WhitespaceAfter"})
  public int[] seventyFivePercentOrdered() {
    int[] newArray = new int[this.size];
    int seventyFivePercent = 0;
    if ((this.size % 2) != 0) {
      seventyFivePercent = (int) Math.ceil(this.size * 0.75);
    }
    else {
      seventyFivePercent = (int) (this.size * 0.75);
    }

    int[] firstHalf = Arrays.copyOfRange(this.array, 0, seventyFivePercent);

    Arrays.sort(firstHalf);

    System.arraycopy(firstHalf, 0, newArray, 0, firstHalf.length);

    if (this.size - firstHalf.length >= 0)
      System.arraycopy(this.array, firstHalf.length, newArray, firstHalf.length, this.size - firstHalf.length);

    return newArray;
  }
}
