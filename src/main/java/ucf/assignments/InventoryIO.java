/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FilenameUtils;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"UnusedDeclaration"})
public class InventoryIO {
  public static boolean saveFile(File myFile, ArrayList<InventoryItem> items) {
    String type = FilenameUtils.getExtension(myFile.getName());
    return switch (type) {
      case "txt" -> saveAsTSV(myFile, items);
      case "json" -> saveAsJSon(myFile, items);
      case "html" -> saveAsHTML(myFile, items);
      default -> false;
    };
  }

  public static boolean saveAsTSV(File myFile, ArrayList<InventoryItem> items) {
    try {
      FileWriter writer = new FileWriter(myFile);
      writer.write("Value\tSerial Number\tName\n");
      for (InventoryItem i: items) {
        writer.write(i.getValue() + "\t" + i.getSerial() + "\t" + i.getName() + "\n");
      }
      writer.flush();
      writer.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean saveAsJSon(File myFile, ArrayList<InventoryItem> items) {
    try {
      Gson gson = new Gson();
      FileWriter writer = new FileWriter(myFile);
      gson.toJson(items, writer);
      writer.flush();
      writer.close();
      return true;
    }
    catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean saveAsHTML(File myFile, ArrayList<InventoryItem> items) {
    try {
      PrintWriter writer = new PrintWriter(new FileWriter(myFile));
      writer.println("<TABLE BORDER><TR><TH>Value<TH>Serial Number<TH>Name</TR>");
      for (InventoryItem i: items) {
        writer.println("<TR><TD>" + i.getValue() + "<TD>" + i.getSerial() +"<TD>" + i.getName());
      }
      writer.println("</TABLE>");
      writer.flush();
      writer.close();
      return true;
    }
    catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static ArrayList<InventoryItem> loadFile(File myFile) {
    String type = FilenameUtils.getExtension(myFile.getName());
    return switch (type) {
      case "txt" -> loadFromTSV(myFile);
      case "json" -> loadFromJSon(myFile);
      case "html" -> loadFromHTML(myFile);
      default -> null;
    };
  }

  public static ArrayList<InventoryItem> loadFromTSV(File myFile) {
    ArrayList<InventoryItem> items = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(myFile);
      String header = scanner.nextLine();
      while (scanner.hasNextLine()) {
        String[] data = scanner.nextLine().split("\t");
        items.add(new InventoryItem(data[1], data[2], new BigDecimal(data[0])));
      }
    } catch (FileNotFoundException | IndexOutOfBoundsException e) {
      e.printStackTrace();
      return null;
    }
    return items;
  }

  public static ArrayList<InventoryItem> loadFromJSon(File myFile) {
    ArrayList<InventoryItem> items = null;
    try {
      Gson gson = new Gson();
      FileReader reader = new FileReader(myFile);
      items = gson.fromJson(reader, new TypeToken<ArrayList<InventoryItem>>() {}.getType());
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return items;
  }

  public static ArrayList<InventoryItem> loadFromHTML(File myFile) {
    ArrayList<InventoryItem> items = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(myFile);
      String header = scanner.nextLine();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.equals("</TABLE>")) {
          String[] data = line.split("<TD>");
          items.add(new InventoryItem(data[2], data[3], new BigDecimal(data[1])));
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
    return items;
  }

}
