package results.create.charts;

import results.ChartCreator;
import sorting.algorithms.InsertionSort;

/**
 * Creates a graph chart for various array sizes and permutations
 * of those arrays.
 */
@SuppressWarnings("Convert2MethodRef") // shut up about lambdas
public class RunInsertionSortCharts {
  /**
   * main method to create arrays and charts.
   *
   * @param args command line arguments
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  // shut up about variable distance
  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();

    ChartCreator random = new ChartCreator(
            insertionSort,
            arrayCreator -> arrayCreator.array(), // Random array
            "Insertion Sort Performance (Random)",
            "Insertion Sort Chart (Random)",
            "insertionSortChartRandom.png"
    );

    ChartCreator ordered = new ChartCreator(
            insertionSort,
            arrayCreator -> arrayCreator.orderedArray(), // Ordered array
            "Insertion Sort Performance (Ordered)",
            "Insertion Sort Chart (Ordered)",
            "insertionSortChartOrdered.png"
    );

    ChartCreator reversed = new ChartCreator(
            insertionSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Insertion Sort Performance (Reversed)",
            "Insertion Sort Chart (Reversed)",
            "insertionSortChartReversed.png"
    );

    ChartCreator fiftyPercentOrdered = new ChartCreator(
            insertionSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Insertion Sort Performance (50% Ordered)",
            "Insertion Sort Chart (50% Ordered)",
            "insertionSortChart50ordered.png"
    );

    ChartCreator seventyFivePercentOrdered = new ChartCreator(
            insertionSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Insertion Sort Performance (75% Ordered)",
            "Insertion Sort Chart (75% Ordered)",
            "insertionSortChart75ordered.png"
    );

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}


