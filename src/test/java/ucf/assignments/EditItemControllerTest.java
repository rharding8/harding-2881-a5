/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EditItemControllerTest {

  @Test
  void updateItemValid() {
    EditItemController controller = new EditItemController();
    controller.storage.addItem("XXX9991010", "Test Item Before", new BigDecimal("5.00"));
    InventoryItem og = controller.storage.getItems().get(0);
    controller.i = controller.storage.getItems().get(0);
    assertTrue(controller.updateItem("777999HJF1", "Test Item After", "10.00"));
    assertNotEquals(og, controller.storage.getItems().get(0));
  }

  @Test
  void updateItemInvalid() {
    EditItemController controller = new EditItemController();
    controller.storage.addItem("XXX9991010", "Test Item Before", new BigDecimal("5.00"));
    controller.i = controller.storage.getItems().get(0);
    assertFalse(controller.updateItem("aiofioajf%$%", "", "YOYOYO"));
  }
}