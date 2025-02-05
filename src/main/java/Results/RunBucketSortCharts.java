package Results;

import SortingAlgorithms.BucketSort;

public class RunBucketSortCharts {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();

        ChartCreator random =
                new ChartCreator(
                        bucketSort,
                        arrayCreator -> arrayCreator.array(), // Random array
                        "Bucket Sort Performance (Random)",
                        "Bucket Sort Chart (Random)",
                        "bucketSortChartRandom.png");

        ChartCreator ordered =
                new ChartCreator(
                        bucketSort,
                        arrayCreator -> arrayCreator.orderedArray(), // Ordered array
                        "Bucket Sort Performance (Ordered)",
                        "Bucket Sort Chart (Ordered)",
                        "bucketSortChartOrdered.png");

        ChartCreator reversed =
                new ChartCreator(
                        bucketSort,
                        arrayCreator -> arrayCreator.reversedArray(), // Ordered array
                        "Bucket Sort Performance (Reversed)",
                        "Bucket Sort Chart (Reversed)",
                        "bucketSortChartReversed.png");

        ChartCreator fiftyPercentOrdered =
                new ChartCreator(
                        bucketSort,
                        arrayCreator -> arrayCreator.fiftyPercentOrdered(), // 50% ordered array
                        "Bucket Sort Performance (50% Ordered)",
                        "Bucket Sort Chart (50% Ordered)",
                        "bucketSortChart50ordered.png");

        ChartCreator seventyFivePercentOrdered =
                new ChartCreator(
                        bucketSort,
                        arrayCreator -> arrayCreator.seventyFivePercentOrdered(), // 50% ordered array
                        "Bucket Sort Performance (75% Ordered)",
                        "Bucket Sort Chart (75% Ordered)",
                        "bucketSortChart75ordered.png");

        random.createChart();
        ordered.createChart();
        reversed.createChart();
        fiftyPercentOrdered.createChart();
        seventyFivePercentOrdered.createChart();
    }
}