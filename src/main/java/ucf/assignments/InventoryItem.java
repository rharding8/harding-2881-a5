/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import java.math.BigDecimal;
import java.util.Objects;

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

  public String getSerial() {
    // Return String serial
    return serial;
  }

  public void setSerial(String serial) {
    // Set serial to given String
    this.serial = serial;
  }

  public BigDecimal getValue() {
    // Return Monetary value
    return value;
  }

  public void setValue(BigDecimal value) {
    // Set value to given BigDecimal value
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    // Overridden equals operation
    // if the given object is equal to this
      // return true
    // if the given object is null or a different class
      // return false
    // Cast given object to this class
    // return true only if all fields are equal
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InventoryItem that = (InventoryItem) o;
    return serial.equals(that.serial) && name.equals(that.name) && value.equals(that.value);
  }

  @Override
  public int hashCode() {
    // Return hash from all properties
    return Objects.hash(serial, name, value);
  }
}
