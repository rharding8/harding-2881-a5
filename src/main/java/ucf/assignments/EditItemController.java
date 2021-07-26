/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.math.BigDecimal;

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
  @FXML
  public Label invalidSerialLabel;
  @FXML
  public Label invalidNameLabel;
  @FXML
  public Label invalidValueLabel;

  InventoryStore storage;
  InventoryItem i;
  SceneManager sceneManager;

  public EditItemController() {
    storage = new InventoryStore();
  }

  public EditItemController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  public void exit() {
    storage.refreshTable();
    Stage stage = (Stage) serialField.getScene().getWindow();
    stage.close();
  }

  @FXML
  public void updateItemClicked(ActionEvent actionEvent) {
    refreshLabels();
    if (updateItem(serialField.getText(), nameField.getText(), valueField.getText())) {
      refreshFields();
      exit();
    }
  }

  @FXML
  public void cancelButtonClicked(ActionEvent actionEvent) {
    refreshLabels();
    refreshFields();
    exit();
  }

  public boolean updateItem(String serial, String name, String value) {
    boolean check = true;
    if (!Validator.serialValidator(serial)) {
      if (invalidSerialLabel != null)
        invalidSerialLabel.setVisible(true);
      check = false;
    }
    if (!serial.equals(i.getSerial()) && storage.getSerialSet().contains(serial)) {
      if (invalidSerialLabel != null)
        invalidSerialLabel.setVisible(true);
      check = false;
    }
    if (!Validator.nameValidator(name)) {
      if (invalidNameLabel != null)
        invalidNameLabel.setVisible(true);
      check = false;
    }
    if (value == null) {
      if (invalidValueLabel != null)
        invalidValueLabel.setVisible(true);
      return false;
    }
    try {
      BigDecimal money = new BigDecimal(value);
      if (check) {
        storage.removeItem(i);
        storage.addItem(serial, name, money);
      }
    }
    catch (NumberFormatException e) {
      if (invalidValueLabel != null)
        invalidValueLabel.setVisible(true);
      check = false;
    }
    return check;
  }

  public void refreshLabels() {
    invalidSerialLabel.setVisible(false);
    invalidNameLabel.setVisible(false);
    invalidValueLabel.setVisible(false);
  }

  public void refreshFields() {
    serialField.setText(null);
    nameField.setText(null);
    valueField.setText(null);
    i = null;
  }

  @FXML
  public void showData(MouseEvent mouseEvent) {
    if (i == null) {
      i = storage.selectedItem;
      serialField.setText(i.getSerial());
      nameField.setText(i.getName());
      valueField.setText(i.getValue().toString());
    }
  }
}
