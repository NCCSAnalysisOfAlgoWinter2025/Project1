package Results;

import SortingAlgorithms.BubbleSort;

public class RunBubbleSortCharts {
  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();

    ChartCreator random =
        new ChartCreator(
            bubbleSort,
            arrayCreator -> arrayCreator.array(), // Random array
            "Bubble Sort Performance (Random)",
            "Bubble Sort Chart (Random)",
            "bubbleSortChartRandom.png");

    ChartCreator ordered =
        new ChartCreator(
            bubbleSort,
            arrayCreator -> arrayCreator.orderedArray(), // Ordered array
            "Bubble Sort Performance (Ordered)",
            "Bubble Sort Chart (Ordered)",
            "bubbleSortChartOrdered.png");

    ChartCreator reversed =
        new ChartCreator(
            bubbleSort,
            arrayCreator -> arrayCreator.reversedArray(), // Ordered array
            "Bubble Sort Performance (Reversed)",
            "Bubble Sort Chart (Reversed)",
            "bubbleSortChartReversed.png");

    ChartCreator fiftyPercentOrdered =
        new ChartCreator(
            bubbleSort,
            arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
            "Bubble Sort Performance (50% Ordered)",
            "Bubble Sort Chart (50% Ordered)",
            "bubbleSortChart50ordered.png");

    ChartCreator seventyFivePercentOrdered =
        new ChartCreator(
            bubbleSort,
            arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
            "Bubble Sort Performance (75% Ordered)",
            "Bubble Sort Chart (75% Ordered)",
            "bubbleSortChart75ordered.png");

    random.createChart();
    ordered.createChart();
    reversed.createChart();
    fiftyPercentOrdered.createChart();
    seventyFivePercentOrdered.createChart();
  }
}
