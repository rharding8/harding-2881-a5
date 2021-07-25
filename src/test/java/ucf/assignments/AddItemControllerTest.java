/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddItemControllerTest {

  @Test
  void addItemValidInput() {
    AddItemController controller = new AddItemController();
    assertTrue(controller.addItem("XXX990734G", "Test Item", "6.00"));
  }

  @Test
  void addItemInvalidInput() {
    AddItemController controller = new AddItemController();
    assertFalse(controller.addItem("safjnsdgnsjf$%", "", "6.00"));
  }

  @Test
  void addItemInvalidMoney() {
    AddItemController controller = new AddItemController();
    assertFalse(controller.addItem("XXX990734G", "Test Item", "heyheyhey"));
  }

  @Test
  void addItemDuplicateSerial() {
    AddItemController controller = new AddItemController();
    assertTrue(controller.addItem("XXX990734G", "Test Item", "6.00"));
    assertFalse(controller.addItem("XXX990734G", "Test 2", "8.00"));
  }
}