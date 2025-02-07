package results.create.charts;

import results.ChartCreator;
import sorting.algorithms.CountingSort;

/**
 * Creates a graph chart for various array sizes and permutations
 * of those arrays.
 */
@SuppressWarnings("Convert2MethodRef") // shut up about lambdas
public class RunCountingSortCharts {
  /**
   * main method to create arrays and charts.
   *
   * @param args command line arguments
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  // shut up about variable distance
  public static void main(String[] args) {
    CountingSort countingSort = new CountingSort();

    ChartCreator random = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.array(), // Random array
            "Counting Sort Performance (Random)",
            "Counting Sort Chart (Random)",
            "countingSortChartRandom.png"
    );

    ChartCreator ordered = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.orderedArray(), // Ordered array
            "Counting Sort Performance (Ordered)",
            "Counting Sort Chart (Ordered)",
            "countingSortChartOrdered.png"
    );

    ChartCreator reversed = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Counting Sort Performance (Reversed)",
            "Counting Sort Chart (Reversed)",
            "countingSortChartReversed.png"
    );

    ChartCreator fiftyPercentOrdered = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Counting Sort Performance (50% Ordered)",
            "Counting Sort Chart (50% Ordered)",
            "countingSortChart50ordered.png"
    );

    ChartCreator seventyFivePercentOrdered = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Counting Sort Performance (75% Ordered)",
            "Counting Sort Chart (75% Ordered)",
            "countingSortChart75ordered.png"
    );

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}




