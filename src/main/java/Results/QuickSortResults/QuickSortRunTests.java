package Results.QuickSortResults;

import java.awt.*;
import java.io.*;
import java.net.URI;
import org.jfree.data.json.impl.JSONArray;

public class QuickSortRunTests {
  public static void main(String[] args) {
    //JSONArray generateData = generateData();
    //saveData(generateData);
    openWebsite();
  }

  private static JSONArray generateData() {

    return null;
  }

  private static void saveData(JSONArray generateData) {
    File file = new File("./results/QuickSortResults/QuickSortResults.json");
    if (file.exists()) {
      if (file.canWrite()) {
        file.delete();
      }
    }
    if (!file.canWrite()) {
      System.out.println("Can't write to file");
      System.exit(1);
    }
    try {
      var result = file.createNewFile();
    } catch (IOException e) {
      System.out.println("Something went wrong when creating the file: " + e.getMessage());
      System.exit(1);
    }
    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter(file);
      fileWriter.write(generateData.toString());
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

}
