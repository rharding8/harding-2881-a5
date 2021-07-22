/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditItemController {
  @FXML
  public TextField serialField;
  @FXML
  public TextField nameField;
  @FXML
  public TextField valueField;
  @FXML
  public Button updateItemButton;
  @FXML
  public Button cancelButton;

  InventoryStore storage;
  InventoryItem item;
  SceneManager sceneManager;

  public EditItemController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void updateItemClicked(ActionEvent actionEvent) {
  }

  @FXML
  public void cancelButtonClicked(ActionEvent actionEvent) {
    exit();
  }

  public void exit() {
    Stage stage = (Stage) serialField.getScene().getWindow();
    stage.close();
  }

  public void setItem(InventoryItem i) {
    item = i;
  }
}
