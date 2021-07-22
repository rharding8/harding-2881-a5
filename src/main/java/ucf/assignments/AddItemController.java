/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 Ryan Harding
 */

package ucf.assignments;

public class AddItemController {
  InventoryStore storage;
  SceneManager sceneManager;

  public AddItemController(InventoryStore storage, SceneManager sceneManager) {
    this.storage = storage;
    this.sceneManager = sceneManager;
  }
}
