package tempresults.create.charts;

import tempresults.ChartCreator;
import sorting.algorithms.MergeSort;

/**
 * Creates a graph chart for various array sizes and permutations
 * of those arrays.
 */
@SuppressWarnings("Convert2MethodRef") // shut up about lambdas
public class RunMergeSortCharts {
  /**
   * main method to create arrays and charts.
   *
   * @param args command line arguments
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  // shut up about variable distance
  public static void main(String[] args) {
    // Create an instance of MergeSort
    MergeSort mergeSort = new MergeSort();

    // Create instances of ChartCreator using method references
    ChartCreator random = new ChartCreator(
            mergeSort,
            arrayCreator -> arrayCreator.array(), // Random array
            "Merge Sort Performance (Random)",
            "Merge Sort Chart (Random)",
            "mergeSortChartRandom.png"
    );

    ChartCreator ordered = new ChartCreator(
            mergeSort,
            arrayCreator -> arrayCreator.orderedArray(), // Ordered array
            "Merge Sort Performance (Ordered)",
            "Merge Sort Chart (Ordered)",
            "mergeSortChartOrdered.png"
    );

    ChartCreator reversed = new ChartCreator(
            mergeSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Merge Sort Performance (Reversed)",
            "Merge Sort Chart (Reversed)",
            "mergeSortChartReversed.png"
    );

    ChartCreator fiftyPercentOrdered = new ChartCreator(
            mergeSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Merge Sort Performance (50% Ordered)",
            "Merge Sort Chart (50% Ordered)",
            "mergeSortChart50ordered.png"
    );

    ChartCreator seventyFivePercentOrdered = new ChartCreator(
            mergeSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Merge Sort Performance (75% Ordered)",
            "Merge Sort Chart (75% Ordered)",
            "mergeSortChart75ordered.png"
    );

    // Create the charts
    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}

