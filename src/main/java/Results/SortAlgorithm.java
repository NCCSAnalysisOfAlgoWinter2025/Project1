package Results;


/**
 * Function interface for passing specific sorting algorithm into the constructor
 * of the ChartCreator class
 */
@FunctionalInterface
public interface SortAlgorithm {
  void sort(int[] array);
}

