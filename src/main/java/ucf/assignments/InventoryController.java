/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
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
  public Button saveButton;
  public Button loadButton;
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
    searchByBox.setItems(FXCollections.observableArrayList("Serial Number", "Name"));
    editItemButton.disableProperty().bind(Bindings.isEmpty(tableDisplay.getSelectionModel().getSelectedItems()));
    removeItemButton.disableProperty().bind(Bindings.isEmpty(tableDisplay.getSelectionModel().getSelectedItems()));
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
    tableDisplay.getSelectionModel().select(search((String) searchByBox.getValue(), searchField.getText()));
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

  public InventoryItem search(String choice, String searchStr) {
    if (choice == null || searchStr == null) {
      return null;
    }
    if (choice.equals("Serial Number"))
    {
      return searchBySerial(searchStr);
    }
    else if (choice.equals("Name")) {
      return searchByName(searchStr);
    }
    else {
      return null;
    }
  }

  public InventoryItem searchBySerial(String search) {
    for (InventoryItem i: storage.getItems()) {
      if (i.getSerial().equals(search.toUpperCase())) {
        return i;
      }
    }
    return null;
  }

  public InventoryItem searchByName(String search) {
    for (InventoryItem i: storage.getItems()) {
      if (i.getName().equals(search)) {
        return i;
      }
    }
    return null;
  }

  public void saveButtonClicked(ActionEvent actionEvent) {
  }

  public void loadButtonClicked(ActionEvent actionEvent) {
  }
}
