/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryControllerTest {

  @Test
  void removeItem() {
    InventoryController controller = new InventoryController();
    InventoryItem item = new InventoryItem("XXXXXXXX09", "Item To Remove", new BigDecimal("1.00"));
    controller.storage.getItems().add(item);
    controller.removeItem(item);
    assertEquals(0, controller.storage.getItems().size());
  }

  @Test
  void searchInvalid() {
    InventoryController controller = new InventoryController();
    ArrayList<InventoryItem> ogItems = new ArrayList<>();
    ogItems.add(new InventoryItem("AAAAAAAA01", "Item 1", new BigDecimal("1.00")));
    ogItems.add(new InventoryItem("BBBBBBBB02", "Item 2", new BigDecimal("2.00")));
    ogItems.add(new InventoryItem("CCCCCCCC03", "Item 3", new BigDecimal("3.00")));
    controller.storage.setItems(ogItems);
    InventoryItem i = controller.search("Nope", "Item 0");
    assertNull(i);
  }

  @Test
  void searchBySerial() {
    InventoryController controller = new InventoryController();
    ArrayList<InventoryItem> ogItems = new ArrayList<>();
    ogItems.add(new InventoryItem("AAAAAAAA01", "Item 1", new BigDecimal("1.00")));
    ogItems.add(new InventoryItem("BBBBBBBB02", "Item 2", new BigDecimal("2.00")));
    ogItems.add(new InventoryItem("CCCCCCCC03", "Item 3", new BigDecimal("3.00")));
    controller.storage.setItems(ogItems);
    InventoryItem i = controller.search("Serial Number", "CCCCCCCC03");
    assertNotNull(i);
    assertEquals(i, controller.searchBySerial("CCCCCCCC03"));
  }

  @Test
  void searchByName() {
    InventoryController controller = new InventoryController();
    ArrayList<InventoryItem> ogItems = new ArrayList<>();
    ogItems.add(new InventoryItem("AAAAAAAA01", "Item 1", new BigDecimal("1.00")));
    ogItems.add(new InventoryItem("BBBBBBBB02", "Item 2", new BigDecimal("2.00")));
    ogItems.add(new InventoryItem("CCCCCCCC03", "Item 3", new BigDecimal("3.00")));
    controller.storage.setItems(ogItems);
    InventoryItem i = controller.search("Name", "Item 2");
    assertNotNull(i);
    assertEquals(i, controller.searchByName("Item 2"));
  }
}