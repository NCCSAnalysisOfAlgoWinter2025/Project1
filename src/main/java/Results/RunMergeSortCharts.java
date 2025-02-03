package Results;

import SortingAlgorithms.MergeSort;

public class RunMergeSortCharts {
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




