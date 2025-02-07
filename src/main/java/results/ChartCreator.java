package results;

import array.creator.ArrayCreator;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Class for creating x/y charts for algorithm run times.
 */
@SuppressWarnings("CallToPrintStackTrace")
// for catch statement at bottom of class
public class ChartCreator {

  private final SortAlgorithm currentSort;
  private final ArrayMethod arrayMethod;
  private final String xy;
  private final String chart;
  private final String png;

  /**
   * Default constructor.
   *
   * @param currentSort algorithm to be used
   * @param arrayMethod method from array.creator to be used
   * @param xy String for chart title
   * @param chart bottom comment for chart
   * @param png png file to be created
   */
  public ChartCreator(SortAlgorithm currentSort, ArrayMethod arrayMethod, String xy, String chart,
                      String png) {
    this.currentSort = currentSort;
    this.arrayMethod = arrayMethod;
    this.xy = xy;
    this.chart = chart;
    this.png = png;
  }

  /**
   * Runs the algorithm labeled currentSort and times it.
   *
   * @param inputArray array to be sorted
   * @return time in milliseconds(ms) it took for the array to be sorted
   */
  public long timer(ArrayCreator inputArray) {
    int len = inputArray.getSize();
    long start = System.currentTimeMillis();
    currentSort.sort(arrayMethod.execute(inputArray));
    long end = System.currentTimeMillis();
    long time = end - start;
    System.out.printf("Array size %d: %dms\n", len, time);
    return time;
  }

  /**
   * Creates an X/Y axis chart that shows how the algorithm performs across different iterations
   * of the original array and also different sizes of each of those arrays.
   */
  public void createChart() {
    // Create dataset
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series = new XYSeries(this.xy);

    for (int i = 4; i <= 32768; i *= 2) {
      ArrayCreator arrayCreator = new ArrayCreator(i);
      series.add(i, timer(arrayCreator));
    }
    dataset.addSeries(series);

    // Create chart
    JFreeChart chart =
            ChartFactory.createXYLineChart(
                    this.chart, // Chart title
                    "Size of array", // X-Axis Label
                    "Time in ms", // Y-Axis Label
                    dataset // Dataset
            );

    // Save the chart as a PNG file
    try {
      ChartUtils.saveChartAsPNG(new File(this.png), chart, 800, 600);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

