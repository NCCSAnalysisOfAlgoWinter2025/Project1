package Results;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import ArrayCreator.ArrayCreator;

public class ChartCreator {

  private SortAlgorithm sort;
  private ArrayMethod arrayMethod;
  private String xy;
  private String chart;
  private String png;

  public ChartCreator(SortAlgorithm sort, ArrayMethod arrayMethod, String xy, String chart, String png){
    this.sort = sort;
    this.arrayMethod = arrayMethod;
    this.xy = xy;
    this.chart = chart;
    this.png = png;
  }

  public long timer(ArrayCreator inputArray){
    int len = inputArray.getSize();
    long start = System.currentTimeMillis();
    sort.sort(arrayMethod.execute(inputArray));
    long end = System.currentTimeMillis();
    long time = end - start;
    System.out.printf("Array size %d: %dms\n", len, time);
    return time;
  }

  public void createChart(){
    // Create dataset
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series = new XYSeries(this.xy);

    for(int i = 4;i <= 32768;i*=2){
      ArrayCreator array = new ArrayCreator(i);
      series.add(i, timer(array));
    }
    dataset.addSeries(series);

    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
            this.chart, // Chart title
            "Size of array",           // X-Axis Label
            "Time in ms",           // Y-Axis Label
            dataset              // Dataset
    );

    // Save the chart as a PNG file
    try {
      ChartUtils.saveChartAsPNG(new File(this.png), chart, 800, 600);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}





