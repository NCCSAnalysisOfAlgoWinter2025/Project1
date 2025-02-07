package tempresults;

import array.creator.ArrayCreator;

/**
 * Functional interface so you can pass the specific array you want
 * into the timer() method inside ChartCreator.
 */
@FunctionalInterface
public interface ArrayMethod {
  /**
   * Allows the substitution of a method of your choosing.
   *
   * @param arrayCreator creates various arrays
   * @return an array
   */
  int[] execute(ArrayCreator arrayCreator);
}

