/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import java.math.BigDecimal;

public class InventoryItem {
  // Strings for serial number and name
  // BigDecimal to store monetary value
  private String serial;
  private String name;
  private BigDecimal value;

  public InventoryItem(String serial, String name, BigDecimal value) {
    // Set serial, name, and value to given inputs
    this.serial = serial;
    this.name = name;
    this.value = value;
  }

  public String getName() {
    // Return String name
    return name;
  }

  public void setName(String name) {
    // Set name to given String
    this.name = name;
  }

  public BigDecimal getValue() {
    // Return Monetary value
    return value;
  }

  public void setValue(BigDecimal value) {
    // Set value to given BigDecimal value
    this.value = value;
  }

  public String getSerial() {
    // Return String serial
    return serial;
  }

  public void setSerial(String serial) {
    // Set serial to given String
    this.serial = serial;
  }
}
