package Results;

import SortingAlgorithms.HeapSort;

public class RunHeapSortCharts {
  public static void main(String[] args) {
    HeapSort heapSort = new HeapSort();

    ChartCreator random =
        new ChartCreator(
            heapSort,
            arrayCreator -> arrayCreator.array(), // Random array
            "Heap Sort Performance (Random)",
            "Heap Sort Chart (Random)",
            "heapSortChartRandom.png");

    ChartCreator ordered =
        new ChartCreator(
            heapSort,
            arrayCreator -> arrayCreator.orderedArray(), // Ordered array
            "Heap Sort Performance (Ordered)",
            "Heap Sort Chart (Ordered)",
            "heapSortChartOrdered.png");

    ChartCreator reversed =
        new ChartCreator(
            heapSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Heap Sort Performance (Reversed)",
            "Heap Sort Chart (Reversed)",
            "heapSortChartReversed.png");

    ChartCreator fiftyPercentOrdered =
        new ChartCreator(
            heapSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Heap Sort Performance (50% Ordered)",
            "Heap Sort Chart (50% Ordered)",
            "heapSortChart50ordered.png");

    ChartCreator seventyFivePercentOrdered =
        new ChartCreator(
            heapSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Heap Sort Performance (75% Ordered)",
            "Heap Sort Chart (75% Ordered)",
            "heapSortChart75ordered.png");

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}
