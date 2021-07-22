/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryController {
  public TableView tableDisplay;
  public Button addItemButton;
  public Button editItemButton;
  public Button removeItemButton;
  public TextField searchField;
  public ChoiceBox searchByBox;
  public Button searchButton;
  InventoryStore storage;
  SceneManager sceneManager;

  public InventoryController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  public void addItemClicked(ActionEvent actionEvent) {
  }

  public void editItemClicked(ActionEvent actionEvent) {
  }

  public void removeItemClicked(ActionEvent actionEvent) {
  }

  public void searchClicked(ActionEvent actionEvent) {
  }
}
