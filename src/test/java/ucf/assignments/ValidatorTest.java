/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

  @Test
  void nameValidatorValidName() {
    String name = "Test Item";
    assertTrue(Validator.nameValidator(name));
  }

  @Test
  void nameValidatorShortName() {
    String name = "a";
    assertFalse(Validator.nameValidator(name));
  }

  @Test
  void nameValidatorLongName() {
    String name =
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAX";
    assertFalse(Validator.nameValidator(name));
  }

  @Test
  void nameValidatorNoName() {
    assertFalse(Validator.nameValidator(null));
  }

  @Test
  void serialValidatorValidSerial() {
    assertTrue(Validator.serialValidator("XX997345BH"));
  }

  @Test
  void serialValidatorInvalidSerial() {
    assertFalse(Validator.serialValidator("sadlnnasfjn$#@sjnf09"));
  }
}