/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {
  public TextField serialField;
  public TextField nameField;
  public TextField valueField;
  public Button addItemButton;
  public Button cancelButton;
  InventoryStore storage;
  SceneManager sceneManager;

  public AddItemController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  public void addItemClicked(ActionEvent actionEvent) {
    storage.addItem(serialField.getText(), nameField.getText(), Double.parseDouble(valueField.getText()));
    exit();
  }

  public void cancelButtonClicked(ActionEvent actionEvent) {
    exit();
  }

  public void exit() {
    Stage stage = (Stage) serialField.getScene().getWindow();
    stage.close();
  }
}
