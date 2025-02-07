package tempresults.create.charts;

import tempresults.ChartCreator;
import sorting.algorithms.RadixSort;

/**
 * Creates a graph chart for various array sizes and permutations
 * of those arrays.
 */
@SuppressWarnings("Convert2MethodRef") // so it will quit complaining about lambdas
public class RunRadixSortCharts {
  /**
   * main method.
   *
   * @param args command line arguments
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  public static void main(String[] args) {
    RadixSort radixSort = new RadixSort();

    ChartCreator random =
            new ChartCreator(
                    radixSort,
                    arrayCreator -> arrayCreator.array(), // Random array
                    "Radix Sort Performance (Random)",
                    "Radix Sort Chart (Random)",
                    "radixSortChartRandom.png");

    ChartCreator ordered =
            new ChartCreator(
                    radixSort,
                    arrayCreator -> arrayCreator.orderedArray(), // Ordered array
                    "Radix Sort Performance (Ordered)",
                    "Radix Sort Chart (Ordered)",
                    "radixSortChartOrdered.png");

    ChartCreator reversed =
            new ChartCreator(
                    radixSort,
                    arrayCreator -> arrayCreator.reversedArray(), // Ordered array
                    "Radix Sort Performance (Reversed)",
                    "Radix Sort Chart (Reversed)",
                    "radixSortChartReversed.png");

    ChartCreator fiftyPercentOrdered =
            new ChartCreator(
                    radixSort,
                    arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
                    "Radix Sort Performance (50% Ordered)",
                    "Radix Sort Chart (50% Ordered)",
                    "radixSortChart50ordered.png");

    ChartCreator seventyFivePercentOrdered =
            new ChartCreator(
                    radixSort,
                    arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
                    "Radix Sort Performance (75% Ordered)",
                    "Radix Sort Chart (75% Ordered)",
                    "radixSortChart75ordered.png");

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}

