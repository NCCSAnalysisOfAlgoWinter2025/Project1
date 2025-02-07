package tempresults.create.charts;

import tempresults.ChartCreator;
import sorting.algorithms.ShellSort;

/**
 * Creates a graph chart for various array sizes and permutations
 * of those arrays.
 */
@SuppressWarnings("Convert2MethodRef") // shut up about lambdas
public class RunShellSortCharts {
  /**
   * main method to create arrays and charts.
   *
   * @param args command line arguments
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  // shut up about variable distance
  public static void main(String[] args) {
    ShellSort shellSort = new ShellSort();

    ChartCreator random =
            new ChartCreator(
                    shellSort,
                    arrayCreator -> arrayCreator.array(), // Random array
                    "Shell Sort Performance (Random)",
                    "Shell Sort Chart (Random)",
                    "shellSortChartRandom.png");

    ChartCreator ordered =
            new ChartCreator(
                    shellSort,
                    arrayCreator -> arrayCreator.orderedArray(), // Ordered array
                    "Shell Sort Performance (Ordered)",
                    "Shell Sort Chart (Ordered)",
                    "shellSortChartOrdered.png");

    ChartCreator reversed =
            new ChartCreator(
                    shellSort,
                    arrayCreator -> arrayCreator.reversedArray(), // Ordered array
                    "Shell Sort Performance (Reversed)",
                    "Shell Sort Chart (Reversed)",
                    "shellSortChartReversed.png");

    ChartCreator fiftyPercentOrdered =
            new ChartCreator(
                    shellSort,
                    arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
                    "Shell Sort Performance (50% Ordered)",
                    "Shell Sort Chart (50% Ordered)",
                    "shellSortChart50ordered.png");

    ChartCreator seventyFivePercentOrdered =
            new ChartCreator(
                    shellSort,
                    arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
                    "Shell Sort Performance (75% Ordered)",
                    "Shell Sort Chart (75% Ordered)",
                    "shellSortChart75ordered.png");

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}