import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class SimpleBarChart {

  public static void main(String[] args) {
    // Create dataset
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(1, "Series1", "Category1");
    dataset.addValue(4, "Series1", "Category2");
    dataset.addValue(3, "Series1", "Category3");

    // Create chart
    JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Example",   // Chart title
            "Category",            // X-axis Label
            "Value",               // Y-axis Label
            dataset                // Dataset
    );

    // Save the chart as a PNG file
    try {
      ChartUtils.saveChartAsPNG(new File("BarChart.png"), chart, 800, 600);
      System.out.println("Chart saved as BarChart.png");
    } catch (IOException e) {
      System.err.println("Error saving chart: " + e.getMessage());
    }
  }
}
