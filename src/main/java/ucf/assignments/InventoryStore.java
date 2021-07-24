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
  private ArrayList<InventoryItem> items;
  private Set<String> serialSet = new HashSet<>();

  public InventoryItem selectedItem;
  public TableView<InventoryItem> table;

  public InventoryStore() {
    items = new ArrayList<>();
  }

  public InventoryStore(ArrayList<InventoryItem> items) {
    this.items = items;
    for (InventoryItem i: this.items) {
      serialSet.add(i.getSerial());
    }
  }

  public boolean addItem(String serial, String name, BigDecimal value) {
    if (serialSet.contains(serial)) {
      return false;
    }
    serialSet.add(serial);
    items.add(new InventoryItem(serial, name, value));
    return true;
  }

  public boolean removeItem(InventoryItem i) {
    if (!serialSet.contains(i.getSerial())) {
      return false;
    }
    serialSet.remove(i.getSerial());
    items.remove(i);
    return true;
  }

  public ArrayList<InventoryItem> getItems() {
    return items;
  }

  public Set<String> getSerialSet() {
    return serialSet;
  }

  public void refreshTable() {
    table.setItems(FXCollections.observableArrayList(getItems()));
  }
}
