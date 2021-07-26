/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.scene.control.TableView;

import java.math.BigDecimal;
import java.util.*;

public class InventoryStore {
  // ArrayList to store all InventoryItems
  // Set to store serial numbers to ensure no items can have the same serial
  private ArrayList<InventoryItem> items;
  private Set<String> serialSet = new HashSet<>();

  // Store a selected Inventory Item to carry between windows
  // Store the table to display all the items
  public InventoryItem selectedItem;
  public TableView<InventoryItem> table;

  public InventoryStore() {
    // Initialize items as a new ArrayList
    items = new ArrayList<>();
  }

  public void addItem(String serial, String name, BigDecimal value) {
    // Add serial to serialSet
    // Add a new InventoryItem created from given parameters to items
    serialSet.add(serial);
    items.add(new InventoryItem(serial, name, value));
  }

  public void removeItem(InventoryItem i) {
    // Remove the serial of i from serialSet
    // Remove i from items
    serialSet.remove(i.getSerial());
    items.remove(i);
  }

  public ArrayList<InventoryItem> getItems() {
    // Return items
    return items;
  }

  public void setItems(ArrayList<InventoryItem> items) {
    // Set items to given ArrayList
    // Reset serialSet
    // for every InventoryItem in the ArrayList
      // add the serial to serialSet
    this.items = items;
    serialSet = new HashSet<>();
    for (InventoryItem i: items) {
      serialSet.add(i.getSerial());
    }
  }

  public Set<String> getSerialSet() {
    // Return serialSet
    return serialSet;
  }

  public void refreshTable() {
    // Clear the table
    // Set the table to show the items using an observableArrayList
    table.setItems(null);
    table.setItems(FXCollections.observableArrayList(getItems()));
  }
}
