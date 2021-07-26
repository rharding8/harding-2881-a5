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
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddItemController {
  @FXML
  public TextField serialField;
  @FXML
  public TextField nameField;
  @FXML
  public TextField valueField;
  @FXML
  public Button addItemButton;
  @FXML
  public Button cancelButton;
  @FXML
  public Label invalidSerialLabel;
  @FXML
  public Label invalidNameLabel;
  @FXML
  public Label invalidValueLabel;

  public InventoryStore storage;
  public SceneManager sceneManager;

  public AddItemController() {
    storage = new InventoryStore();
  }

  public AddItemController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void addItemClicked(ActionEvent actionEvent) {
    refreshLabels();
    if (addItem(serialField.getText(), nameField.getText(), valueField.getText())) {
      refreshFields();
      refreshTable();
      exit();
    }
  }

  @FXML
  public void cancelButtonClicked(ActionEvent actionEvent) {
    refreshLabels();
    refreshFields();
    exit();
  }

  public void exit() {
    Stage stage = (Stage) serialField.getScene().getWindow();
    stage.close();
  }

  public boolean addItem(String serial, String name, String value) {
    boolean check = true;
    if (!Validator.serialValidator(serial) || storage.getSerialSet().contains(serial)) {
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
      money = money.setScale(2, RoundingMode.HALF_UP);
      if (check) {
        storage.addItem(serial.toUpperCase(), name, money);
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
  }

  public void refreshTable() {
    storage.refreshTable();
  }
}
