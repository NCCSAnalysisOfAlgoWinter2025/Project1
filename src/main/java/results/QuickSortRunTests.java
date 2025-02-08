package results;

import array.creator.ArrayCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import sorting.algorithms.QuickSort;

/**
 * Class for running tests on quick sort algorithms.
 */
public class QuickSortRunTests {
  /**
   * main method for running file.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    String generateData = generateData();
    saveData(generateData);
    openWebsite();
  }

  /**
   * Saves the generated data to a JSON file.
   *
   * @param generateData the data to be saved
   */
  private static void saveData(String generateData) {
    File file = new File("./QuickSortResults.json");

    FileWriter fileWriter;
    try {
      fileWriter = new FileWriter(file);
      fileWriter.write(generateData);
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Something went wrong when writing the file: " + e.getMessage());
    }
  }

  /**
   * Opens a website to display the QuickSort results.
   */
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
      try {
        Desktop.getDesktop().browse(new URI("localhost:5173"));
      } catch (Exception e) {
        System.out.println("Something went wrong when opening the website: " + e.getMessage());
      }

    } else {
      System.out.println("Detected Linux/OSX. Opening website...");
    }
    builder.command("sh", "-c", "npm install;open ./ & open localhost:5173");

    Process process;
    try {
      process = builder.start();
      process.waitFor(30, TimeUnit.SECONDS);
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong when opening the website: " + e.getMessage());
    }
  }

  /**
   * Generates test data for the QuickSort algorithms and converts it to JSON format.
   *
   * @return a JSON string representation of the test data
   */
  private static String generateData() {
    List<AlgoTests> allData = new LinkedList<>();

    allData.add(runTests("QuickSort Pivot First Element", QuickSort::quickSortFE));
    allData.add(runTests("QuickSort Pivot Random Element", QuickSort::quickSortRE));
    allData.add(runTests("QuickSort Pivot Median of 3", QuickSort::quickSortMedian));

    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allData);
    } catch (JsonProcessingException e) {
      System.out.println(
          "Something went wrong when converting the data to JSON: " + e.getMessage());
      System.exit(1);
    }
    return null; // Make compiler happy, will never actually run
  }

  /**
   * Runs tests on the specified sorting algorithm and collects the results.
   *
   * @param nameOfAlgo the name of the algorithm being tested
   * @param algo the sorting algorithm to be tested
   * @return an instance of AlgoTests containing the results of the tests
   */
  private static AlgoTests runTests(String nameOfAlgo, SortingAlgo algo) {
    AlgoTests results = new AlgoTests(nameOfAlgo);
    AlgoTest dataRand = new AlgoTest("Random Array");
    AlgoTest dataRevOr = new AlgoTest("Reversed ordered Array");
    AlgoTest dataOrdered = new AlgoTest("Ordered Array");
    AlgoTest data50PerOrd = new AlgoTest("50% Ordered Array");
    AlgoTest data75PerOrd = new AlgoTest("75% Ordered Array");

    // warm up the JVM
    algo.sort(new int[] {1, 2, 3, 4});

    for (int i = 1; i < 16; i++) {
      ArrayCreator arr = new ArrayCreator((int) Math.abs(Math.pow(2, i)));
      int[] arrToSort;

      // Random
      arrToSort = Arrays.copyOfRange(arr.array(), 0, arr.array().length);
      long startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result because we literally don't care
      long endTime = System.nanoTime();
      long elapsedTime = Math.absExact((endTime - startTime));

      data50PerOrd.addDataPoint(new DataPoint(arr.getSize(), elapsedTime, true));

      dataRand.addDataPoint(new DataPoint(arr.getSize(), elapsedTime, true));

      // Reversed
      arrToSort = arr.reversedArray();
      runTestMayFail(algo, dataRevOr, arr, arrToSort);

      // Ordered
      arrToSort = arr.orderedArray();
      runTestMayFail(algo, dataOrdered, arr, arrToSort);

      // 50% ordered
      arrToSort = arr.fiftyPercentOrdered();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result because we literally don't care
      endTime = System.nanoTime();
      elapsedTime = Math.absExact((endTime - startTime));

      data50PerOrd.addDataPoint(new DataPoint(arr.getSize(), elapsedTime, true));

      // 75% ordered
      arrToSort = arr.seventyFivePercentOrdered();
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result because we literally don't care
      endTime = System.nanoTime();
      elapsedTime = Math.absExact((endTime - startTime));

      data75PerOrd.addDataPoint(new DataPoint(arr.getSize(), elapsedTime, true));
    }

    results.addTest(dataRand);
    results.addTest(dataRevOr);
    results.addTest(dataOrdered);
    results.addTest(data50PerOrd);
    results.addTest(data75PerOrd);

    return results;
  }

  /**
   * Runs a test on the specified sorting algorithm and records the elapsed time.
   * If a StackOverflowError occurs, it records the failure.
   *
   * @param algo the sorting algorithm to be tested
   * @param algoTest the AlgoTest instance to record results
   * @param arr the ArrayCreator instance used for generating arrays
   * @param arrToSort the array to be sorted
   */
  private static void runTestMayFail(
      SortingAlgo algo, AlgoTest algoTest, ArrayCreator arr, int[] arrToSort) {
    long startTime;
    long endTime;
    long elapsedTime;
    try {
      startTime = System.nanoTime();
      algo.sort(arrToSort); // not storing result because we literally don't care
      endTime = System.nanoTime();
      elapsedTime = Math.absExact((endTime - startTime));

      algoTest.addDataPoint(new DataPoint(arr.getSize(), elapsedTime, true));
    } catch (StackOverflowError e) {
      algoTest.addDataPoint(new DataPoint(arr.getSize(), 0, false));
    }
  }

  /**
   * Functional interface for sorting algorithms.
   * Provides a method to sort an array of integers.
   */
  @FunctionalInterface
  private interface SortingAlgo {
    void sort(int[] arr);
  }

  /**
   * Represents a collection of tests for a specific sorting algorithm.
   * Contains the algorithm's name and a list of tests performed.
   */
  private static class AlgoTests {
    public final String algoName;
    public final List<AlgoTest> tests = new LinkedList<>();

    public AlgoTests(String algoName) {
      this.algoName = algoName;
    }

    public void addTest(AlgoTest test) {
      this.tests.add(test);
    }
  }

  /**
   * Represents a single test case for a sorting algorithm.
   * Contains the test name and a list of data points recorded during the test.
   */
  private static class AlgoTest {
    public final String testName;
    public final List<DataPoint> dataPoints = new ArrayList<>();

    public AlgoTest(String testName) {
      this.testName = testName;
    }

    public void addDataPoint(DataPoint dataPoint) {
      this.dataPoints.add(dataPoint);
    }
  }

  /**
   * Represents a data point recorded during a sorting test.
   * Contains the size of the array, the elapsed time, and the success status.
   */
  private static class DataPoint {
    public final int arrSize;
    public final long deltaTime;
    public boolean success;

    /**
     * Constructs a DataPoint instance with the specified parameters.
     *
     * @param arrSize the size of the array
     * @param deltaTime the time taken to sort the array
     * @param success the success status of the sorting operation
     */
    public DataPoint(int arrSize, long deltaTime, boolean success) {
      this.arrSize = arrSize;
      this.deltaTime = deltaTime;
      this.success = success;
    }
  }
}
