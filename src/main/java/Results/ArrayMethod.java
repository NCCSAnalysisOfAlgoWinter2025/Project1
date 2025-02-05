package Results;

import ArrayCreator.ArrayCreator;

/**
 * Functional interface so you can pass the specific array you want
 * into the timer() method inside ChartCreator
 */
@FunctionalInterface
public interface ArrayMethod {
  int[] execute(ArrayCreator arrayCreator);
}

