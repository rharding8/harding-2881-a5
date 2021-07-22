/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InventoryIO {
  public static boolean saveJson(String path, InventoryStore storage) {
    try {
      Gson gson = new Gson();
      FileWriter writer = new FileWriter(path);
      gson.toJson(storage.getItems(), writer);
      writer.flush();
      writer.close();
    }
    catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static InventoryStore loadJson(String path) {
    InventoryStore storage;
    try {
      Gson gson = new Gson();
      FileReader reader = new FileReader(path);
      Map<String, InventoryItem> items = gson.fromJson(reader, new TypeToken<Map<String, InventoryItem>>() {}.getType());
      storage = new InventoryStore(items);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      storage = new InventoryStore();
    }
    return storage;
  }

  public static boolean saveTSV(String path, InventoryStore storage) {
    try {
      FileWriter writer = new FileWriter(path);
      Set<String> keySet = storage.getItems().keySet();
      for (String serial: keySet) {
        InventoryItem item = storage.getItems().get(serial);
        writer.write(item.getValue() + "\t" + serial + "\t" + item.getName());
      }
      writer.flush();
      writer.close();
    }
    catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static InventoryStore loadTSV(String path) {
    InventoryStore storage = new InventoryStore();
    try {
      Scanner scanner = new Scanner(path);
      while(scanner.hasNextLine()) {
        String[] strings = scanner.nextLine().split("\t");
        storage.addItem(strings[1], strings[2], Double.parseDouble(strings[0]));
      }
      scanner.close();
    }
    catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return storage;
  }
}
