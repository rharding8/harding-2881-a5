/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import org.apache.commons.io.FilenameUtils;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryIO {
  public static void saveFile(File myFile, ArrayList<InventoryItem> items) {
    String type = FilenameUtils.getExtension(myFile.getName());
    if (type.equals("txt")) {
      saveAsTSV(myFile, items);
    }
    else if (type.equals("json")) {
      saveAsJSon(myFile, items);
    }
    else {
      System.out.println("Not so fast!");
    }
  }

  public static void saveAsTSV(File myFile, ArrayList<InventoryItem> items) {
    try {
      FileWriter writer = new FileWriter(myFile);
      writer.write("Value\tSerial Number\tName\n");
      for (InventoryItem i: items) {
        writer.write(i.getValue() + "\t" + i.getSerial() + "\t" + i.getName() + "\n");
      }
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void saveAsJSon(File myFile, ArrayList<InventoryItem> items) {
    try {
      Gson gson = new Gson();
      FileWriter writer = new FileWriter(myFile);
      gson.toJson(items, writer);
      writer.flush();
      writer.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<InventoryItem> loadFile(File myFile) {
    String type = FilenameUtils.getExtension(myFile.getName());
    if (type.equals("txt")) {
      return loadFromTSV(myFile);
    }
    else if (type.equals("json")) {
      return loadFromJSon(myFile);
    }
    else {
      System.out.println("Not so fast!");
      return null;
    }
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
    } catch (FileNotFoundException e) {
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
}
