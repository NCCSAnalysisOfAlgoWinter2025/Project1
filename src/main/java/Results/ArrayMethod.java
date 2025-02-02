package Results;

import ArrayCreator.ArrayCreator;

@FunctionalInterface
public interface ArrayMethod {
  int[] execute(ArrayCreator arrayCreator);
}
