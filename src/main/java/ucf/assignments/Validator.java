/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import java.math.BigDecimal;

public class Validator {
  public static boolean nameValidator (String name) {
    if (name == null) {
      return false;
    }
    return name.length() >= 2 && name.length() <= 256;
  }

  public static boolean serialValidator (String serial) {
    if (serial == null) {
      return false;
    }
    if (serial.length() != 10) {
      return false;
    }
    for (char c: serial.toCharArray()) {
      if (!Character.isLetterOrDigit(c)) {
        return false;
      }
    }
    return true;
  }
}
