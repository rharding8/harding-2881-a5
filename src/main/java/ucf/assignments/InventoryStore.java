/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import java.util.HashMap;
import java.util.Map;

public class InventoryStore {
  private Map<String, InventoryItem> items;

  public InventoryStore() {
    items = new HashMap<>();
  }

  public InventoryStore(Map<String, InventoryItem> items) {
    this.items = items;
  }

  public boolean addItem(String serial, String name, double value) {
    if (items.containsKey(serial)) {
      return false;
    }
    items.put(serial, new InventoryItem(name,value));
    return true;
  }

  public boolean removeItem(String serial) {
    if (!items.containsKey(serial)) {
      return false;
    }
    items.remove(serial);
    return true;
  }

  public Map<String, InventoryItem> getItems() {
    return items;
  }
}
