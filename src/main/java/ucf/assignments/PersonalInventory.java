 /*
  * UCF COP3330 Summer 2021 Assignment 5 Solution
  * Copyright 2021 Ryan Harding
  */

 package ucf.assignments;

 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;

 import java.io.IOException;

 public class PersonalInventory extends Application {

   // Standard JavaFX start code
   public static void main(String[] args) {
     launch(args);
   }

   @Override
   public void start(Stage primaryStage) {
     // Instantiate sceneManager and load the controllers
     // Set the stage to the scene "Inventory"
     // Set the title of the window to "Inventory Manager"
     // Show the window
     SceneManager sceneManager = new SceneManager();
     sceneManager.load();
     primaryStage.setScene(sceneManager.getScene("Inventory"));
     primaryStage.setTitle("Inventory Manager");
     primaryStage.show();
   }
 }
