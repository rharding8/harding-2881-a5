/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

public class Validator {

  public static boolean nameValidator (String name) {
    // if name is null
      // return false
    // if length of name is between 2 and 256 inclusive
      // return true
    // else
      // return false
    if (name == null) {
      return false;
    }
    return name.length() >= 2 && name.length() <= 256;
  }

  public static boolean serialValidator (String serial) {
    // if serial is null
      // return false
    // if length of serial is not 10
      // return false
    // for every character in String serial
      // if the character is not alphanumeric
        // return false
    // return true
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
