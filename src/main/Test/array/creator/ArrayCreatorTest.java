package array.creator;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCreatorTest {

  private ArrayCreator arrayObject;
  private int[] arr;
  private int length;

  @BeforeEach
  public void setUp() {
    arrayObject = new ArrayCreator(4);
    arr = arrayObject.array();
    length = arr.length;
  }

  @Test
  void orderedArray() {
    int[] actual = arrayObject.orderedArray();
    int[] expected = new int[length];
    System.arraycopy(arr, 0, expected, 0, length);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }

  @Test
  void reversedArray() {
    int[] actual = arrayObject.reversedArray();
    int[] expected = new int[length];
    System.arraycopy(arr, 0, expected, 0, length);
    Arrays.sort(expected);

    int left = 0;
    int right = expected.length - 1;

    while (left < right) {
      int temp = expected[left];
      expected[left] = expected[right];
      expected[right] = temp;
      left++;
      right--;
    }

    assertArrayEquals(expected, actual);
  }
//
//  @Test
//  void fiftyPercentOrdered() {
//  }
//
//  @Test
//  void seventyFivePercentOrdered() {
//  }
}