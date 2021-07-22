/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

public class InventoryItem {
  private String serial;
  private String name;
  private double value;

  public InventoryItem(String serial, String name, double value) {
    this.serial = serial;
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }
}
