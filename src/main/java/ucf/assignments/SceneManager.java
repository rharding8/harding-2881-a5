/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
  Map<String, Scene> scenes = new HashMap<>();

  void load() {
    InventoryStore storage = new InventoryStore();

    InventoryController inventoryController = new InventoryController(storage, this);
    AddItemController addItemController = new AddItemController(storage, this);
    EditItemController editItemController = new EditItemController(storage, this);

    Parent root;

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
    loader.setController(inventoryController);
    try {
      root = loader.load();
      scenes.put("Inventory", new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }

    loader = new FXMLLoader(getClass().getResource("AddItem.fxml"));
    loader.setController(addItemController);
    try {
      root = loader.load();
      scenes.put("AddItem", new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }

    loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
    loader.setController(editItemController);
    try {
      root = loader.load();
      scenes.put("EditItem", new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Scene getScene(String name) {
    return scenes.get(name);
  }
}
