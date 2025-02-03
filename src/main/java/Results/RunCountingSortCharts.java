package Results;

import SortingAlgorithms.CountingSort;

public class RunCountingSortCharts {
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
            "Insertion Sort Performance (Ordered)",
            "Counting Sort Chart (Ordered)",
            "countingSortChartOrdered.png"
    );

    ChartCreator reversed = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Insertion Sort Performance (Reversed)",
            "Counting Sort Chart (Reversed)",
            "countingSortChartReversed.png"
    );

    ChartCreator fiftyPercentOrdered = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Insertion Sort Performance (50% Ordered)",
            "Counting Sort Chart (50% Ordered)",
            "countingSortChart50ordered.png"
    );

    ChartCreator seventyFivePercentOrdered = new ChartCreator(
            countingSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Insertion Sort Performance (75% Ordered)",
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




