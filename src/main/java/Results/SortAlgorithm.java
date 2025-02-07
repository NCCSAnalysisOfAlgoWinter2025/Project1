package results;


/**
 * Function interface for passing specific sorting algorithm into the constructor
 * of the ChartCreator class.
 */
@FunctionalInterface
public interface SortAlgorithm {
  /**
   * sort algorithm from respective sorting algorithm class.
   *
   * @param array array to be passed
   */
  void sort(int[] array);
}

