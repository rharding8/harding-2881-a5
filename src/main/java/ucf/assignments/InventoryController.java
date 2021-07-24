/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InventoryController {
  @FXML
  public TableView<InventoryItem> tableDisplay;
  @FXML
  public Button refreshButton;
  @FXML
  TableColumn<String, InventoryItem> col1;
  @FXML
  TableColumn<String, InventoryItem> col2;
  @FXML
  TableColumn<String, InventoryItem> col3;
  @FXML
  public Button addItemButton;
  @FXML
  public Button editItemButton;
  @FXML
  public Button removeItemButton;
  @FXML
  public TextField searchField;
  @FXML
  public ChoiceBox searchByBox;
  @FXML
  public Button searchButton;

  InventoryStore storage;
  SceneManager sceneManager;

  public InventoryController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void initialize() {
    col1.setCellValueFactory(new PropertyValueFactory<>("value"));
    col2.setCellValueFactory(new PropertyValueFactory<>("serial"));
    col3.setCellValueFactory(new PropertyValueFactory<>("name"));
    storage.table = tableDisplay;
    refresh();
  }

  @FXML
  public void addItemClicked(ActionEvent actionEvent) {
    // Call the enter method for "AddItem"
    enterWindow("AddItem");
  }

  @FXML
  public void editItemClicked(ActionEvent actionEvent) {
    storage.selectedItem = tableDisplay.getSelectionModel().getSelectedItem();
    enterWindow("EditItem");
  }

  @FXML
  public void removeItemClicked(ActionEvent actionEvent) {
    removeItem(tableDisplay.getSelectionModel().getSelectedItem());
  }

  @FXML
  public void searchClicked(ActionEvent actionEvent) {
  }

  public void enterWindow(String window) {
    Stage newStage = new Stage();
    newStage.setScene(sceneManager.getScene(window));
    newStage.setTitle("Item Manager");
    newStage.initModality(Modality.WINDOW_MODAL);
    newStage.initOwner(addItemButton.getScene().getWindow());
    newStage.show();
  }

  public void refresh() {
    storage.refreshTable();
  }

  @FXML
  public void refreshButtonClicked(ActionEvent actionEvent) {
    refresh();
  }

  public void removeItem(InventoryItem i) {
    storage.removeItem(i);
    refresh();
  }
}
