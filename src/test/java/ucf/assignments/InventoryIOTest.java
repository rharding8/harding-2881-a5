/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryIOTest {

  @Test
  void saveAsTSV() {
    ArrayList<InventoryItem> items = new ArrayList<>();
    items.add(new InventoryItem("00000000AB", "Test Item", new BigDecimal("1.00")));
    File myFile = new File(getClass().getResource("./").getPath() + "savedInventory.txt");
    InventoryIO.saveAsTSV(myFile, items);
    assertTrue(myFile.exists());
  }

  @Test
  void saveAsJSon() {
    ArrayList<InventoryItem> items = new ArrayList<>();
    items.add(new InventoryItem("00000000AB", "Test Item", new BigDecimal("1.00")));
    File myFile = new File(getClass().getResource("./").getPath() + "savedInventory.json");
    InventoryIO.saveAsJSon(myFile, items);
    assertTrue(myFile.exists());
  }

  @Test
  void saveAsHTML() {
    ArrayList<InventoryItem> items = new ArrayList<>();
    items.add(new InventoryItem("00000000AB", "Test Item", new BigDecimal("1.00")));
    File myFile = new File(getClass().getResource("./").getPath() + "savedInventory.html");
    InventoryIO.saveAsHTML(myFile, items);
    assertTrue(myFile.exists());
  }

  @Test
  void loadFromTSV() {
    File myFile = new File(getClass().getResource("MyInventory.txt").getPath());
    ArrayList<InventoryItem> items = null;
    items = InventoryIO.loadFromTSV(myFile);
    assertNotNull(items);
  }

  @Test
  void loadFromJSon() {
    File myFile = new File(getClass().getResource("MyInventory.json").getPath());
    ArrayList<InventoryItem> items = null;
    items = InventoryIO.loadFromJSon(myFile);
    assertNotNull(items);
  }

  @Test
  void loadFromHTML() {
    File myFile = new File(getClass().getResource("MyInventory.html").getPath());
    ArrayList<InventoryItem> items = null;
    items = InventoryIO.loadFromHTML(myFile);
    assertNotNull(items);
  }

  @Test
  void loadSameData() {
    File TSVFile = new File(getClass().getResource("MyInventory.txt").getPath());
    File JSonFile = new File(getClass().getResource("MyInventory.json").getPath());
    File HTMLFile = new File(getClass().getResource("MyInventory.html").getPath());
    ArrayList<InventoryItem> TSVItems = InventoryIO.loadFromTSV(TSVFile);
    ArrayList<InventoryItem> JSonItems = InventoryIO.loadFromJSon(JSonFile);
    ArrayList<InventoryItem> HTMLItems = InventoryIO.loadFromHTML(HTMLFile);
    assertEquals(TSVItems.size(), JSonItems.size());
    assertEquals(TSVItems.size(), HTMLItems.size());
    assertEquals(JSonItems.size(), HTMLItems.size());
    for (int i = 0; i < TSVItems.size(); i++) {
      assertEquals(TSVItems.get(i), JSonItems.get(i));
      assertEquals(TSVItems.get(i), HTMLItems.get(i));
      assertEquals(JSonItems.get(i), HTMLItems.get(i));
    }
  }
}