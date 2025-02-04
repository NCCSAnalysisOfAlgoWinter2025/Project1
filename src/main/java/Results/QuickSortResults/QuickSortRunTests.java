package Results.QuickSortResults;

import ArrayCreator.ArrayCreator;
import SortingAlgorithms.QuickSortFE;
import SortingAlgorithms.QuickSortMedian;
import SortingAlgorithms.QuickSortRE;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuickSortRunTests {
  public static void main(String[] args) {
    String generateData = generateData();
    saveData(generateData);
    //openWebsite();
  }

  private static void saveData(String generateData) {
    File file = new File("./results/QuickSortResults/QuickSortResults.json");
    if (file.exists()) {
      if (file.canWrite()) {
        file.delete();
      }
    }
//    if (!file.canWrite()) {
//      System.out.println("Can't write to file");
//      System.exit(1);
//    }
    try {
      var result = file.createNewFile();
    } catch (IOException e) {
      System.out.println("Something went wrong when creating the file: " + e.getMessage());
      System.exit(1);
    }
    FileWriter fileWriter;
    try {
      fileWriter = new FileWriter(file);
      fileWriter.write(generateData);
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Something went wrong when writing the file: " + e.getMessage());
    }
  }

  private static void openWebsite() {
    System.out.println("Opening website...");


    File whereToRun = new File("./QuickSortResultsSite/");
    if (!whereToRun.exists()) {
      System.out.println("The Website directory does not exit? ");
      System.exit(1);
    }
    boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    ProcessBuilder builder = new ProcessBuilder();
    builder.directory(whereToRun);
    if (isWindows) {
      System.out.println("Detected Windows. Opening website...");
      builder.command("cmd.exe", "/c", "npm install;npm run dev & open localhost:5173");
      try{
        Desktop.getDesktop().browse(new URI("localhost:5173"));
      }catch (Exception e) {
        System.out.println("Something went wrong when opening the website: " + e.getMessage());
      }

    } else {
      System.out.println("Detected Linux/OSX. Opening website...");
    }
    builder.command("sh", "-c", "npm install;npm run dev & open localhost:5173");

    Process process = null;
    try {
      process = builder.start();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }







  }

  private static String generateData() {
    List<AlgoTests> allData = new LinkedList<>();

//    allData.add(runTests("QuickSort Pivot First Element", QuickSortFE::sort));
    allData.add(runTests("QuickSort Pivot Random Element", QuickSortRE::sort));
    allData.add(runTests("QuickSort Pivot Median of 3", QuickSortMedian::sort));


    ObjectMapper mapper = new ObjectMapper();
      try {
          return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allData);
      } catch (JsonProcessingException e) {
          System.out.println("Something went wrong when converting the data to JSON: " + e.getMessage());
          System.exit(1);
      }
      return null; // Make compiler happy, will never actually run
  }

  private static AlgoTests runTests(String nameOfAlgo, SortingAlgo algo) {
    AlgoTests results = new AlgoTests(nameOfAlgo);
    AlgoTest dataRand = new AlgoTest("Random Array");
    AlgoTest dataRevOr = new AlgoTest("Reversed ordered Array");
    AlgoTest dataOrdered = new AlgoTest("Ordered Array");
    AlgoTest data50PerOrd = new AlgoTest("50% Ordered Array");
    AlgoTest data75PerOrd = new AlgoTest("75% Ordered Array");




    for (int i = 1; i < 16; i++) {
      ArrayCreator arr = new ArrayCreator((int)Math.abs(Math.pow(2, i)));
      int[] arrToSort = arr.array();

      // Random
      long startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result cause we literally don't care
      long endTime = System.nanoTime();
      long elapsedTimeMS = Math.absExact((endTime - startTime) / 1_000_000);

      dataRand.addDataPoint(new DataPoint(arr.getSize(), elapsedTimeMS));

      // Reversed
      arrToSort = arr.reversedArray();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result cause we literally don't care
      endTime = System.nanoTime();
      elapsedTimeMS = Math.absExact((endTime - startTime));

      dataRevOr.addDataPoint(new DataPoint(arr.getSize(), elapsedTimeMS));

      // Ordered
      arrToSort = arr.orderedArray();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result cause we literally don't care
      endTime = System.nanoTime();
      elapsedTimeMS = Math.absExact((endTime - startTime));

      dataOrdered.addDataPoint(new DataPoint(arr.getSize(), elapsedTimeMS));



      // 50% ordered
      arrToSort = arr.fiftyPercentOrdered();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result cause we literally don't care
      endTime = System.nanoTime();
      elapsedTimeMS = Math.absExact((endTime - startTime));

      data50PerOrd.addDataPoint(new DataPoint(arr.getSize(), elapsedTimeMS));

      // 75% ordered
      arrToSort = arr.seventyFivePercentOrdered();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result cause we literally don't care
      endTime = System.nanoTime();
      elapsedTimeMS = Math.absExact((endTime - startTime));

      data75PerOrd.addDataPoint(new DataPoint(arr.getSize(), elapsedTimeMS));
    }


    results.addTest(dataRand);
    results.addTest(dataRevOr);
    results.addTest(dataOrdered);
    results.addTest(data50PerOrd);
    results.addTest(data75PerOrd);



    return results;
  }

  @FunctionalInterface
  private interface SortingAlgo{
    int[] sort(int[] arr);
  }

  private static class AlgoTests{
    public final String AlgoName;
    public final List<AlgoTest> tests = new LinkedList<>();

    public AlgoTests(String AlgoName) {
      this.AlgoName = AlgoName;
    }
    public void addTest(AlgoTest test){
      this.tests.add(test);
    }
  }

  private static class AlgoTest{
    public final String testName;
    public final List<DataPoint> dataPoints = new ArrayList<>();
    public AlgoTest(String testName) {
      this.testName = testName;
    }
    public  void addDataPoint(DataPoint dataPoint){
      this.dataPoints.add(dataPoint);
    }
  }

  private static class DataPoint{
    public final int arrSize;
    public final long deltaTime;
    public DataPoint(int arrSize, long deltaTime) {
      this.arrSize = arrSize;
      this.deltaTime = deltaTime;
    }
  }

}
