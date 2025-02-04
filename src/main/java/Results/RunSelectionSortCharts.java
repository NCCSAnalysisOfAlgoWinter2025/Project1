package Results;

import SortingAlgorithms.SelectionSort;

public class RunSelectionSortCharts {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        ChartCreator random =
                new ChartCreator(
                        selectionSort,
                        arrayCreator -> arrayCreator.array(), // Random array
                        "Selection Sort Performance (Random)",
                        "Selection Sort Chart (Random)",
                        "selectionSortChartRandom.png");

        ChartCreator ordered =
                new ChartCreator(
                        selectionSort,
                        arrayCreator -> arrayCreator.orderedArray(), // Ordered array
                        "Selection Sort Performance (Ordered)",
                        "Selection Sort Chart (Ordered)",
                        "selectionSortChartOrdered.png");

        ChartCreator reversed =
                new ChartCreator(
                        selectionSort,
                        arrayCreator -> arrayCreator.reversedArray(), // Ordered array
                        "Selection Sort Performance (Reversed)",
                        "Selection Sort Chart (Reversed)",
                        "selectionSortChartReversed.png");

        ChartCreator fiftyPercentOrdered =
                new ChartCreator(
                        selectionSort,
                        arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
                        "Selection Sort Performance (50% Ordered)",
                        "Selection Sort Chart (50% Ordered)",
                        "selectionSortChart50ordered.png");

        ChartCreator seventyFivePercentOrdered =
                new ChartCreator(
                        selectionSort,
                        arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
                        "Selection Sort Performance (75% Ordered)",
                        "Selection Sort Chart (75% Ordered)",
                        "selectionSortChart75ordered.png");

        random.createChart();
        ordered.createChart();
        reversed.createChart();
        fiftyPercentOrdered.createChart();
        seventyFivePercentOrdered.createChart();
    }
}